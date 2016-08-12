package com.optimais.httptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

                File file = new File("/storage/sdcard/Desert.jpg");

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.18.81.155:8080/").build();

                FileUploadService service = retrofit.create(FileUploadService.class);

                RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);

                String s = "1006";
                RequestBody description = RequestBody.create(MediaType.parse("text/plain"), s);

                Call<ResponseBody> call = service.upload(description, body);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("main", response.body().string());
                            Log.d("main",Thread.currentThread().getName());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    public interface FileUploadService {
        @Multipart
        @POST("EntranceGuardes/app/appOpen_pushdDataToApp.action")
        Call<ResponseBody> upload(@Part("userId") RequestBody description,
                                  @Part MultipartBody.Part file);

    }


}
