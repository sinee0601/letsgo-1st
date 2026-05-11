package com.letsgo.place.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.service.PlaceServiceInterface;

@WebServlet("/placeLikeAjax")
public class PlaceLikeAjaxServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        //플레이스 데이터 확인함
        String placeId   = request.getParameter("placeId");   
        String placeType = request.getParameter("placeType"); 

        // 로그인 확인
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String userId = (String) session.getAttribute("loginOK");
        if (userId == null) {
            // 로그인 안 됨 → 실패 JSON 응답
            out.print("{\"result\":\"fail\", \"likeCount\":0}");
            return;
        }

       
        PlaceServiceInterface service = new PlaceServiceMB();
        service.setPlaceLikeCount(placeId);

        //  좋아요 수 조회
        int likeCount = service.getPlaceLikeCount(placeType, placeId);

        // JSON 응답
        out.print("{\"result\":\"success\", \"placeId\":\"" + placeId + "\", \"likeCount\":" + likeCount + "}");
    }
}
