package app.project.loginregister.helper;

import retrofit2.Response;

public class ResponseHelper {
    public static <T> boolean isValid(T resp, Response<T> response) {
        return resp != null && response.isSuccessful() && response.body() != null;
    }
}
