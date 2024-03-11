package service_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface PatrolService {
	void service(HttpServletRequest request, HttpServletResponse response);
}
