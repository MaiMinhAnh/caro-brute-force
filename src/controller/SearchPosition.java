/**
 * Copyright(C) [2021] [Luvina Software]
 * Controller.java, Aug 3, 2021, AnhMTM
 */
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * xử lí file thế cờ: đọc file, lưu các thé cờ ra danh sách
 * 
 * @author AnhMTM
 *
 */
public class SearchPosition {
	// khai báo tên file thế cờ
	private String fileName = "theco.txt";
	// khai báo danh sách lưu hết tât các các dòng trong file thế cờ
	private List<String> theCoList = new ArrayList<>();
	// khởi tạo đối tượng FileInputStream
	FileInputStream fileInputStream = null;
	// khởi tạo 1 stream
	private Stream<String> stream;

	/**
	 * đọc file thế cờ
	 * 
	 * @throws IOException
	 * @return theCoList list chứa các dòng trong file thế cờ
	 */
	public List<String> readFile() throws IOException {
		try {
			// đọc file
			stream = Files.lines(Paths.get(fileName));
			// đọc mỗi dòng trong file
			stream.forEach(line -> {
				// thêm vào trong danh sách thế cờ
				theCoList.add(line);
			});
			// trả về file đọc đc
			return theCoList;
			// bắt ngoại lệ
		} catch (Exception e) {
			// in ngoại lệ ra console
			e.printStackTrace();
			// trả về file đọc đc
			return theCoList;
		}
	}

	// khai báo list lưu các thế cờ đọc từ file theco.txt
	List<String> theCoList2 = new ArrayList<>();

	/**
	 * tách 5 dòng là 1 thế cờ và lưu vào 1 list
	 * 
	 * @param theCo file chứa toàn bộ các thế cờ đọc đc
	 * @return theCoList2 danh sách các thế cờ đc tách thành từng phần tử
	 */
	public List<String> convert(List<String> theCo) {
		// khai báo biến đếm số thế cờ
		int i = 0;
		// khai báo chuỗi lưu 1 thế cờ (5 dòng là 1 thế)
		String the = "";
		// duyệt hết list thế cờ
		while (i < theCo.size()) {
			// cộng 5 dòng thành 1 chuỗi - tương đương 1 thế
			the = theCo.get(i) + theCo.get(i + 1) + theCo.get(i + 2) + theCo.get(i + 3) + theCo.get(i + 4);
			// tăng i lên 5 để sang thế cờ tiếp theo
			i += 5;
			// thêm thế cờ vào danh sách
			theCoList2.add(the);
		}

		// tổng tất cả có 210 thế cờ
		System.out.println(theCoList2.size());
		// trả về danh sách các thế cờ
		return theCoList2;
	}

	// khai báo danh sách chứa các ô cờ 5x5 quét đc trên bàn cờ
	List<String> boardScanList = new ArrayList<String>();

	/**
	 * quét ma trận 5x5 lên bàn cờ 20x20
	 * 
	 * @param board ma trân trạng thái bàn cờ 20x20
	 * @return boardScanList danh sách các ô 5x5 quét đc trên bàn cờ
	 */

	public List<String> scanBoard(int[][] board) {
		// khai báo row đếm số hàng
		int row = 0;
		// lặp cho đến khi hết cắc hàng
		while (row < 16) {
			// lặp hết các cột
			for (int col = 0; col < 16; col++) {
				// khai báo biến lưu hàng ma trận 5x5 trên bàn cờ
				int m = row + 5;
				// khai báo biến lưu cột ma trận 5x5 trên bàn cờ
				int n = col + 5;
				// khai báo chuỗi lưu trạng thái ô cờ 5x5
				String line = "";
				// lặp trên ô cờ 5x5
				for (int i = row; i < m; i++) {
					// lặp trên ô cờ 5x5
					for (int j = col; j < n; j++) {
						// thêm trạng thái của các ô vào line
						line += board[i][j];
					}
				}
				// thêm trạng thái của từng ô 5x5 vào danh sách
				boardScanList.add(line);
			}
			// tăng row lên 1
			row++;
		}
		// trả về danh sách trạng thái các ô
		return boardScanList;
	}

	// khai báo biến lưu vị trí trong ô 5x5 nước cờ cần đánh
	public int pos = 0;

	/**
	 * lặp trong danh sách thế cờ và quét bàn cờ để tìm vị trí nước cờ
	 * 
	 * @param theCoList     danh sách các thế cờ được lưu thành chuỗi độ dài 25
	 * @param boardScanList danh sách các ô cờ 5x5 quét đc trên bàn cờ
	 * @return position mảng lưu vị trí điểm cần đánh
	 *
	 */
	// khởi tạo giá trị vị trí nc cờ cần đánh (x, y)
	public int[] position = { -1, -1 };

	/**
	 * tìm kiếm trên bàn cờ vị trí phù hợp với thế cờ
	 */
	public int[] search(List<String> theCoList, List<String> boardScanList) {
		// khởi tạo biến lưu giá trị vị trí điểm cần tìm
		int x = 0, y = 0;
		// duyệt danh sách thế cờ cho đến khi tìm được thế thỏa mãn
		for (int i = 0; i < theCoList.size(); i++) {
			// khởi tạo biến lưu giá trị của 1 thế cờ
			String lineTheCo = theCoList.get(i);
			// duyệt hết bàn cờ
			for (int j = 0; j < boardScanList.size(); j++) {
				// khởi tạo biến lưu giá trị ô cờ 5x5
				String lineBoard = boardScanList.get(j);
				// nếu tìm được vị trí cần đánh
				if (soSanh2Chuoi(lineTheCo, lineBoard)) {
					// tính toán hàng điểm tìm được và án cho x
					x = j / 16 + pos / 5;
					// tính cột điểm tìm được gán cho y
					y = j % 16 + pos % 5;
					// lưu giá trị x, y vào mảng position
					// position[0]: hàng
					position[0] = x;
					// position[1]: cột
					position[1] = y;
					// in ra vị trí điểm tìm được
					System.out.println(position[0] + "," + position[1]);
					// trả về giá trị vị trí điểm tìm được
					return position;
				}

			}
		}
		// trả về giá trị vị trí điểm tìm được
		return position;

	}

	/**
	 * so sánh 2 chuỗi có độ dài bằng nhau tìm ra vị trí của kí tự D
	 * 
	 * @param s1 chuỗi thứ 1
	 * @param s2 chuỗi thứ 2
	 * @return true nếu tìm được và ngược lại
	 */
	public boolean soSanh2Chuoi(String s1, String s2) {
		// boolean flag = true;
		// khai báo biến đếm độ dài chuỗi
		int i = 0;
		// lặp cho đến khi tìm được
		while (i < s1.length()) {
			// nếu s1[i] là X và s2[i] khác 2 thì false
			if (s1.charAt(i) == 'X' && s2.charAt(i) != '2') {
				// trả về false
				return false;
			}
			// nếu s1[i] là O và s2[i] khác 1 thì false
			if (s1.charAt(i) == 'O' && s2.charAt(i) != '1') {
				// trả về false
				return false;
			}
			// nếu s1[i] là D và s2[i] = 0 là vị trí cần tìm
			if (s1.charAt(i) == 'D' && s2.charAt(i) == '0') {
				// gán pos = i
				pos = i;
				// trả về true
				return true;
			}
			// tăng i lên 1
			i++;
		}
		// trả về false
		return false;
	}

}
