package app.project.loginregister.model.server;

import android.content.Context;

import java.io.IOException;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import app.project.loginregister.helper.NetworkHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {
    private Context context;

    @Inject
    public ConnectivityInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!NetworkHelper.isOnline(context)) {
            throw new NoConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }
}
