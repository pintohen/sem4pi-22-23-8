package org.shared.board.server.gson_adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.hibernate.proxy.HibernateProxy;

import java.io.IOException;

public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (HibernateProxy.class.isAssignableFrom(type.getRawType())) {
                return (TypeAdapter<T>) new HibernateProxyTypeAdapter();
            }
            return null;
        }
    };

    @Override
    public void write(JsonWriter out, HibernateProxy value) throws IOException {
        out.nullValue();
    }

    @Override
    public HibernateProxy read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("Deserialization of HibernateProxy is not supported.");
    }
}