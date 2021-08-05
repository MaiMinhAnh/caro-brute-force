/**
 * Copyright(C) [2021] [Luvina Software]
 * CheckWin.java, Aug 3, 2021, AnhMTM
 */
package controller;

import javax.swing.JButton;

/**
 * kiểm tra tháng thua
 * 
 * @author AnhMTM
 *
 */
public class CheckWin {
	// khai báo kích thước mảng lưới caro
	public static int n = 20, m = 20;

	/**
	 * Kiểm tra thắng thua
	 * 
	 * @param x       vị trí điểm cần kiểm tra
	 * @param y       vị trí điển cần kiểm tra
	 * @param name    giá trị text tại ô cần check
	 * @param btn[][] mảng lưu button của bàn cờ
	 * @return boolean trả về true nếu thắng, false nếu chưa thắng
	 *
	 */
	public static boolean win(int x, int y, String name, JButton btn[][]) {
		// khai báo 2 biến
		int k, j;
		// khai báo biến d lưu số điểm
		int d = 0;
		// kiểm tra theo hàng dọc
		for (k = -5; k <= 5; k++) {
			// kiểm tra 4 ô xung quanh tính từ điểm cần xét
			if (x + k >= 0 && x + k < n) {
				// nếu button có giá trị text giống name thì tăng d lên 1
				if (btn[x + k][y].getText() == name) {
					// tăng d lên 1
					d++;
					// nếu chưa đủ 5 ô liền nhau thì chưa thắng
				} else if (d < 5) {
					// reset lại d
					d = 0;
				}
			}
		}
		// nếu có 5 ô liên tiếp giống nhau thì trả về true
		if (d >= 5) {
			return true;
			// ngược lại set d = 0
		} else {
			d = 0;
		}
		// kiểm tra theo hàng ngang
		for (k = -5; k <= 5; k++) {
			// kiểm tra 4 ô xung quanh tính từ điểm cần xét
			if (y + k >= 0 && y + k < n) {
				// nếu button có giá trị text giống name thì tăng d lên 1
				if (btn[x][y + k].getText() == name) {
					// tăng d thêm 1
					d++;
					// nếu k đủ 5 ô liền nhau thi chưa thắng
				} else if (d < 5) {
					// reset d
					d = 0;
				}
			}
		}

		if (d >= 5) {
			// trả về true
			return true;
			// nếu k thì chưa thắng
		} else {
			// reset lại d
			d = 0;
		}
		// kiểm tra đường chéo
		for (k = -5, j = 5; k <= 5 && j >= -5; k++, j--) {
			// kiểm tra đường chéo
			if (y + k >= 0 && y + k < n && x + j >= 0 && x + j < m) {
				// nếu button có giá trị text giống name thì tăng d lên 1
				if (btn[x + j][y + k].getText() == name) {
					// tăng d thêm 1
					d++;
					// nếu k đủ 5 ô liền nhau thi chưa thắng
				} else if (d < 5) {
					// reset d
					d = 0;
				}
			}
		}
		// nếu >= 5 ô liên nhau thì thắng
		if (d >= 5) {
			//trả về true
			return true;
			// nếu k thì chưa thắng
		} else {
			//reset d
			d = 0;
		}
		// kiểm tra đường chéo
		for (k = -5; k <= 5; k++) {
			if (y + k >= 0 && y + k < n && x + k >= 0 && x + k < m) {
				// nếu button có giá trị text giống name thì tăng d lên 1
				if (btn[x + k][y + k].getText() == name) {
					// tăng d thêm 1
					d++;
					// nếu k đủ 5 ô liền nhau thi chưa thắng
				} else if (d < 5) {
					// reset d
					d = 0;
				}
			}
		}
		// nếu >= 5 ô liên nhau thì thắng
		if (d >= 5) {
			//trả về true
			return true;
		}
		//trả về false
		return false;
	}
}
