package worker_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.PatrolService;

public class PatrolWrite implements PatrolService{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("순찰 등록 페이지");
		
	}

}
