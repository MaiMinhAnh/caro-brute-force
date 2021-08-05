/**
 * Copyright(C) [2021] [Luvina Software]
 * BoardState.java, Aug 3, 2021, AnhMTM
 */
package model;

/**
 * lớp ghi lại trạng thái bàn cờ
 * 
 * @author AnhMTM
 *
 */
public class BoardState {
	/**
	 * hàm khởi tạo
	 */
	public BoardState() {
		// phương thức init()
		init();
	}

	// khai báo kích thước ma trận lưu trạng thái
	private int n = 20, m = 20;
	// khai báo ma trân lưu trạng thái bàn cờ
	private int[][] boardArr = new int[n][m];

	/**
	 * hàm khởi tạo mảng lưu trạng thái bàn cờ
	 * @return boardArr mảng trạng thái bàn cờ đc khởi tạo là 0 hết
	 */
	public int[][] init() {
		// n hàng
		for (int i = 0; i < n; i++) {
			// m cột
			for (int j = 0; j < m; j++) {
				// trạng thái ban đầu các ô trên bàn cờ có giá trị 0
				boardArr[i][j] = 0;
			}
		}
		// trả về ma trận trạng thái khởi tạo giá trị ban đầu là 0 hết
		return boardArr;

	}

	/**
	 * lấy trạng thái bàn cờ sau mỗi nước đánh của người hay máy
	 * 
	 * @param x    vị trí thay đổi trạng thái
	 * @param y    vị trí thay đổi trạng thái
	 * @param flag cờ đánh dấu người và máy
	 * @return boardArr trạng thái bàn cờ mỗi khi có 1 lượt đánh
	 */
	public int[][] getBoardState(int x, int y, int flag) {
		// nếu máy vừa đánh
		if (flag == 1) {
			// cập nhập giá trị tương ứng với máy - 2
			boardArr[x][y] = 2;
		}
		// nếu người vừa đánh
		if (flag == 2) {
			// cập nhập giá trị tương ứng với người - 1
			boardArr[x][y] = 1;
		}
		// trả về bẳng trạng thái
		return boardArr;
	}

	/**
	 * in ra bảng trạng thái của bàn cờ
	 */
	public void print() {
		// lặp hết hàng trong bảng
		for (int i = 0; i < m; i++) {
			// lặp hết cột trong bảng
			for (int j = 0; j < n; j++) {
				// in ra trạng thái từng ô
				System.out.print(boardArr[i][j]);
			}
			// xuống dòng khi hết 1 hàng
			System.out.println();
		}
	}

}
