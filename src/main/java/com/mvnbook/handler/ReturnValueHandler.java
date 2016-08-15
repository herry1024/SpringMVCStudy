package com.mvnbook.handler;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.mvnbook.annotation.BaseViewResponseBody;
import com.mvnbook.result.BaseResult;


public class ReturnValueHandler extends RequestResponseBodyMethodProcessor implements HandlerMethodReturnValueHandler {

	public ReturnValueHandler( List<HttpMessageConverter<?>> messageConverters ) {
		super( messageConverters );
	}

	@Override
	public boolean supportsReturnType( MethodParameter returnType ) {
		return ( ( AnnotationUtils.findAnnotation( returnType.getContainingClass(), BaseViewResponseBody.class ) != null ) || ( returnType
				.getMethodAnnotation( BaseViewResponseBody.class ) != null ) );
	}

	@Override
	public void handleReturnValue( Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest )
			throws IOException, HttpMediaTypeNotAcceptableException {
		mavContainer.setRequestHandled( true );
		Object writeObject = null;
		if( !( returnValue instanceof BaseResult ) ) {
			BaseResult result = new BaseResult();
			result.setValue( returnValue );
			writeObject = result;
		} else {
			writeObject = returnValue;
		}
		try {
			writeWithMessageConverters( writeObject, returnType, webRequest );
		} catch( EOFException e ) {
			// ignore EOFException
		}
	}

}
