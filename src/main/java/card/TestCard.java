package card;

import java.util.Map;

import card.model.CardBean;
import card.service.CardService;
import card.service.impl.CardServiceImpl;

public class TestCard {

	public static void main(String[] args) {
		int pageNo =1;
		int recordsPerPage = 8;
		
		CardService service = new CardServiceImpl();
		Map<Integer, CardBean> CardMap = service.getCbPageCards();
		
	
		
		int cardCounts = CardMap.size();
		int totalPages = (int)(Math.ceil( cardCounts / (double)recordsPerPage));
		System.out.println("總筆數:" + cardCounts);
		System.out.println("總頁數:" + totalPages);
	}

}
