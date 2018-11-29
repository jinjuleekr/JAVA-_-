package controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VendingMachine/vending")
public class VendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 돈(inputMoney)이 입력됨 -> result.jsp로 전달
		// 상품 선택(pickedItems) (0-6개 선택 가능) -> 선택값 정제해서 이름 result.jsp에서 보여주기
		// 상품 선택(itemPrice) (0-6개 선택 가능) -> 가격 value값에서 정제해서, String->int 형태 변형
		// 잔액(change) -> (inputMoney-totalPrice)

		String sInputMoney = request.getParameter("inputMoney");
		int inputMoney = Integer.parseInt(sInputMoney);
		String[] items = request.getParameterValues("item");
		String pickedItems = "";
		int itemPrice = 0;
		int totalPrice = 0;
		int change = 0;

		
		
		if (items != null) {
			for (String item : items) {
				int a = item.indexOf('(');
				int b = item.indexOf('원');
				// 가격추출 + int로 바꾸기
				itemPrice = Integer.parseInt(item.substring(a + 1, b));
				// 총구매액 구하기
				totalPrice += itemPrice;
				// 투입금액보다 총구매액이 큰 경우
				if (totalPrice>inputMoney) {
					break;
				}else {}
				// 잔돈 구하기
				change = inputMoney - totalPrice;
				// 선택된 상품 이름 구하기
				pickedItems += item + " ";
			}
		}

		// 데이터 저장하기
		request.setAttribute("inputMoney", inputMoney);
		request.setAttribute("pickedItems", pickedItems);
		request.setAttribute("change", change);

		// result.jsp로 forward
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
