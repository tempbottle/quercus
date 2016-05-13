package com.caucho.quercus.lib.session;

import com.caucho.quercus.env.*;

/**
 * @author wssccc
 */
public class SessionHandlerDelegatedCallback extends SessionCallback {
    ObjectValue sessionHandler;

    public SessionHandlerDelegatedCallback(ObjectValue sessionHandler) {
        super(null, null, null, null, null, null);
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void open(Env env, String savePath, String sessionName) {
        sessionHandler.callMethod(env, env.createString("open"), StringValue.create(savePath), StringValue.create(sessionName));
    }

    @Override
    public StringValue read(Env env, String id) {
        Value value = sessionHandler.callMethod(env, env.createString("read"), StringValue.create(id));
        if (value instanceof StringValue) {
            return (StringValue) value;
        } else {
            return null;
        }
    }

    @Override
    public void write(Env env, String id, String value) {
        sessionHandler.callMethod(env, env.createString("write"), StringValue.create(id), StringValue.create(value));
    }

    @Override
    public void destroy(Env env, String id) {
        sessionHandler.callMethod(env, env.createString("destroy"), StringValue.create(id));
    }

    @Override
    public void close(Env env) {
        sessionHandler.callMethod(env, env.createString("close"));
    }
}
