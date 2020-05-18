package com.appcode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppCodeService {
	@GET("plugin")
	Call<List<Post>> listRepos();
}
