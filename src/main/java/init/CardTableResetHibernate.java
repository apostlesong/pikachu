package init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import card.model.CardBean;
import member.model.MemberBean;

// 本程式建立CARDS的表格

public class CardTableResetHibernate {
//	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	public static void main(String args[]) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		// 1. BookCompany表格
		// 1-1 由"data/bookCompany.dat"逐筆讀入BookCompany表格內的初始資料，
		// 然後依序新增到BookCompany表格中
//		try (
//			FileReader fr = new FileReader("data/cardcsv.csv"); 
//			BufferedReader br = new BufferedReader(fr);
//		) {
//			while ((line = br.readLine()) != null) {
//				if (line.startsWith(UTF8_BOM)) {
//					line = line.substring(1);
//				}
//				String[] token = line.split("\\|");
//				String name = token[0];
//				String address = token[1];
//				String url = token[2];
//				CompanyBean cb = new CompanyBean(null, name, address, url);
//				try {
//					tx = session.beginTransaction();
//					session.save(cb);
//					tx.commit();
//				} catch (Exception ex) {
//					if (tx != null)
//						tx.rollback();
//				}
//			}
//			System.out.println("BookCompany 資料新增成功");
//		} catch (IOException e) {
//			System.err.println("新建BookCompany表格時發生IO例外: " + e.getMessage());
//		}

		// 2. Book表格
		String line = "";
		int count = 0;
		File file = new File("data/cardcsv1.csv");
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "BIG5");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				count++;
				if (count < 2) {
					continue;
				}
				System.out.println("line=" + line);

				String[] token = line.split(",");

				CardBean cb = new CardBean();
//				cb.setC_id();
				cb.setC_name(token[1]);
				token[2] =  token[1].substring(0, token[1].indexOf(" ")); 
				cb.setBank(token[2]);
				cb.setAnnlfee(token[3]);
				String imgname = "data/imgs/" + token[1] + ".jpg";
				Blob c_img = GlobalService.fileToBlob(imgname);
				cb.setC_img(c_img);

				if (token[5].indexOf("null") != -1) {
					token[5] = "0";
				}
				token[5] = token[5].replace("%", "");
				cb.setFcb(Double.parseDouble(token[5].trim()));

				if (token[6].indexOf("null") != -1) {
					token[6] = "0";
				}

				token[6] = token[6].replace("%", "");
				cb.setDcb(Double.parseDouble(token[6].trim()));
				cb.setFcb_n(token[7]);
				cb.setDcb_n(token[8]);
				cb.setFma(token[9]);
				cb.setDma(token[10]);
				cb.setFma_n(token[11]);
				cb.setDma_n(token[12]);

				if (token[13].indexOf("null") != -1) {
					token[13] = "0";
				}
				cb.setRefuel_cb(Double.parseDouble(token[13].trim()));

				cb.setRefuel_dis(token[14]);
				cb.setRefuel_cb_n(token[15]);
				cb.setRefuel_dis_n(token[16]);
				cb.setWkdmoviedis(token[17]);
				cb.setMoviedis(token[18]);
				cb.setWkdmoviedis_n(token[19]);
				cb.setMoviedis_n(token[20]);
				cb.setDitigalfb(token[21]);
				cb.setOnlinefb(token[22]);
				cb.setDitigalfb_n(token[23]);
				cb.setOnlinefb_n(token[24]);
				cb.setZeroins(token[25]);
				cb.setMinins(token[26]);
				cb.setZeroins_n(token[27]);
				cb.setMinins_n(token[28]);
				cb.setMileagefb(token[29]);
				cb.setCashfb(token[30]);
				cb.setMileagefb_n(token[31]);
				cb.setCashfb_n(token[32]);

				if (token[33].indexOf("null") != -1) {
					token[33] = "0";
				}
				cb.setAnnual_income(Integer.parseInt(token[33].trim()));
				cb.setC_type(token[34]);

				try {
					tx = session.beginTransaction();
					// 設外鍵
//					CompanyBean companyBean = 
//							session.get(CompanyBean.class, Integer.parseInt(token[4].trim()));
//					book.setCompanyBean(companyBean);

					session.save(cb);
					tx.commit();
				} catch (Exception ex) {
					if (tx != null)
						tx.rollback();
				}
				System.out.println("新增一筆Book紀錄");
			}
			System.out.println("Book資料新增成功");
		} catch (Exception e) {
			System.err.println("新建BookCompany表格時發生IO例外: " + e.getMessage());
		}

	}

}