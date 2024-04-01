package com.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Controller
public class MemoServlet extends HttpServlet {
	
	private static final Model model = new Model();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Modelからメモを取得します。
		var allMemo = model.getMemo();

		// Modelから受け取ったデータをViewで表示しやすいよう加工するのは、Controllerの役割です。
		// ここでは改行コードごとに分割してListに格納します。
		List<String> memoList;
		if (allMemo.isEmpty()) {
			memoList = List.of();
		}
		else {
			memoList = Arrays.asList(allMemo.split("\n")); 					
		}
		
		// データをViewに渡すため、リクエストスコープへセットします。
		request.setAttribute("memoList", memoList);
		request.getRequestDispatcher("/WEB-INF/memo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Webブラウザから送られてきたデータを取得します。
		var memo = request.getParameter("memo");

		// Modelのメモ追加機能を呼び出します。
		model.addMemo(memo);
		
		// この後の処理はdoGetメソッドと同じなので、doGetに任せます。
		doGet(request, response);
	}
}
