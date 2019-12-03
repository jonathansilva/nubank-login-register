package app.project.loginregister.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import app.project.loginregister.model.server.ConnectivityInterceptor;
import app.project.loginregister.service.LoginService;
import app.project.loginregister.service.UserService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    String provideBaseUrl() {
        return "http://10.0.0.3:3000/";
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Context context, String url) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES);

        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new ConnectivityInterceptor(context));

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Provides
    LoginService provideLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
