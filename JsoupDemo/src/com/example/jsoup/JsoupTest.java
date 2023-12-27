package com.example.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.bean.CryptoInfo;

public class JsoupTest {

	

	public static void cryptoForMarket() throws IOException {
		// 加密或幣行情
		String url = "https://coinmarketcap.com/";

		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36").get();
		Element tbody = doc.selectFirst("tbody");
		Elements trs = tbody.select("tr");
		List<CryptoInfo> cryptos = new ArrayList<>();
		int count = 1;
		for (Element tr : trs) {
			if (count <= 10) {
				CryptoInfo newCrypto = new CryptoInfo();
				newCrypto.setName(tr.child(2).text());
				newCrypto.setPrice(Float.parseFloat(tr.child(3).text().replaceAll("[\\$,]", "")));
				newCrypto.setRate(Float.parseFloat(tr.child(5).text().substring(0, tr.child(5).text().length() - 1)));
				newCrypto.setValue(tr.child(7).text());
				count++;
				cryptos.add(newCrypto);
			} else {
				break;
			}

		}

		for (CryptoInfo crypto : cryptos) {
			System.out.println("貨幣名稱:"+crypto.getName().split(" ")[1]);
			System.out.println("貨幣價格:"+crypto.getPrice()+"$");
			System.out.println("貨幣漲幅:"+crypto.getRate()+"%");
			System.out.println("貨幣市值:"+crypto.getValue()+"$");
			System.out.println("---------------------");
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		cryptoForMarket();

	}
}