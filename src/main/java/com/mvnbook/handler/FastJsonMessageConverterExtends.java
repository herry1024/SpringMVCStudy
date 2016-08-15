package com.mvnbook.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mvnbook.result.BaseResult;

public class FastJsonMessageConverterExtends extends AbstractHttpMessageConverter<Object> {

	public static final Charset UTF8 = Charset.forName( "UTF-8" );

	private Charset charset = UTF8;

	private SerializerFeature[] serializerFeature;

	@Override
	protected boolean supports( Class<?> clazz ) {
		return true;
	}

	public void setSerializerFeature( SerializerFeature[] serializerFeature ) {
		if( null != serializerFeature ) {
			this.serializerFeature = Arrays.copyOf( serializerFeature, serializerFeature.length );
		} else {
			this.serializerFeature = null;
		}
	}

	@Override
	protected Object readInternal( Class<? extends Object> clazz, HttpInputMessage inputMessage ) throws IOException, HttpMessageNotReadableException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		InputStream in = inputMessage.getBody();

		byte[] buf = new byte[ 1024 ];
		for( ;; ) {
			int len = in.read( buf );
			if( len == -1 ) {
				break;
			}

			if( len > 0 ) {
				baos.write( buf, 0, len );
			}
		}

		byte[] bytes = baos.toByteArray();
		if( charset == UTF8 ) {
			return JSON.parseObject( bytes, clazz );
		} else {
			return JSON.parseObject( bytes, 0, bytes.length, charset.newDecoder(), clazz );
		}
	}

	@Override
	protected void writeInternal( Object obj, HttpOutputMessage outputMessage ) throws IOException, HttpMessageNotWritableException {

		OutputStream out = outputMessage.getBody();
		Object writeObject = null;
		if( !( obj instanceof BaseResult ) ) {
			BaseResult result = new BaseResult();
			result.setValue( obj );
			writeObject = result;
		} else {
			writeObject = obj;
		}

		byte[] bytes;

		if( charset == UTF8 ) {
			if( serializerFeature != null ) {
				bytes = JSON.toJSONBytes( writeObject, serializerFeature );
			} else {
				bytes = JSON.toJSONBytes( writeObject );
			}

		} else {
			String text;
			if( serializerFeature != null ) {
				text = JSON.toJSONString( writeObject, serializerFeature );
			} else {
				text = JSON.toJSONString( writeObject );
			}
			bytes = text.getBytes( charset );
		}

		out.write( bytes );
	}

}
