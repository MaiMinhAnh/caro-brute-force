/**
 * Copyright(C) [2021] [Luvina Software]
 * Action.java, Aug 3, 2021, AnhMTM
 */
package controller;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.BoardState;

/**
 * thực hiện bắt sự kiện khi người dùng click bàn cờ và máy đánh
 * 
 * @author AnhMTM
 *
 */
public class PlayGame extends JButton {

	private static final long serialVersionUID = 1L;

	// flag đánh dấu: 1 - người, 2 - máy; mặc định người đánh trc
	public int flag = 1;
	// khai báo kích thước lưới caro
	public int n = 20, m = 20;
	// khai báo lớp CheckWin kiểm tra thắng hay thua
	CheckWin checkWin = new CheckWin();
	// khai báo đối tượng boardState
	BoardState boardState = new BoardState();
	// khai báo mảng lưu trạng thái bàn cờ
	int[][] boardSt = boardState.init();
	// khai báo

	/**
	 * đánh cờ khi đến lượt
	 * 
	 * @param i       tọa độ button theo trục x
	 * @param j       tọa độ button theo trục y
	 * @param btn[][] mảng button trong lưới button
	 */
	public void play(int i, int j, JButton btn[][]) {
		// in ra vị trí button được click
		System.out.println(i + "-" + j);
		// in ra cờ đánh dấu lượt đánh
		System.out.println("flag:" + flag);
		// flag = 2 -> máy đánh
		if (flag == 1) {
			// đến lượt người đánh, set text tại vị trí click là O
			btn[i][j].setText("O");
			// set màu text là đen
			btn[i][j].setForeground(Color.BLACK);
			// chuyển lượt sang máy đánh -> flag = 2
			flag = 2;
			// cập nhập bảng trạng thái
			boardSt = boardState.getBoardState(i, j, flag);
			boardState.print();
			// kiểm tra tại vị trí vừa đánh xem có thắng không
			if (CheckWin.win(i, j, btn[i][j].getText(), btn)) {
				// nếu thắng hiển thị dialog thông báo
				JOptionPane.showMessageDialog(null, "O win!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
				// hiển thị dialog hỏi có muốn chơi màn mới không
				JOptionPane.showMessageDialog(null, "Trò Chơi Mới", "Thoát", JOptionPane.INFORMATION_MESSAGE);
				// reset bàn cờ
				// n hàng
				for (int i1 = 0; i1 < n; i1++) {
					// m cột
					for (int j1 = 0; j1 < m; j1++) {
						// set lại text là rỗng
						btn[i1][j1].setText("");
						// set lại màu button là trắng
						btn[i1][j1].setBackground(Color.white);
					}
				}
			}
		}
		
		//khai báo lớp SearchPosition
		SearchPosition searchPosition = new SearchPosition();
		//khai báo biến lưu danh sách các thế cờ
		List<String> theCoList = new ArrayList<>();
		//khai báo biến lưu danh sách các ô cờ 5x5 quét đc
		List<String> boardScanList = new ArrayList<>();
		try {
			//đọc file và lưu thành danh sách các thế cờ
			theCoList = searchPosition.convert(searchPosition.readFile());
			// bắt ngoại lệ
		} catch (IOException e) {
			//in ra ngoại lệ
			e.printStackTrace();
		}
		//quét mảng trạng thái bàn cờ
		boardScanList = searchPosition.scanBoard(boardSt);
		//tìm vị trí cần đánh tiếp theo danh sách thế cờ và bảng trạng thái
		int[] position = searchPosition.search(theCoList, boardScanList);
		//khai báo giá trị vị trí ô cần đánh
		// x là hàng
		int x = position[0];
		//y là cột
		int y = position[1];
		//nếu đến lượt máy đánh
		if (flag == 2) {
			// trường hợp k tìm ddc vị trí thích hợp trong thế cờ -> đánh random trên bàn cờ
			if (x == -1 || y == -1) {
				//gán giá trị random cho x
				x = (int) (Math.random() * 20);
				//gán giá trị ran dom cho y
				y = (int) (Math.random() * 20);
				//nếu x, y trùng vị trí của nút đánh r
				if (x == i&&y ==j) {
					//gán giá trị random cho x
					x = (int) (Math.random() * 20);
					//gán giá trị ran dom cho y
					y = (int) (Math.random() * 20);
				}
			} else {
				// set text tại vị trí click là X tương đương với máy
				btn[x][y].setText("X");
				// set màu của text là đỏ
				btn[x][y].setForeground(Color.RED);
				// chuyển lượt sang người đánh -> flag = 1
				flag = 1;
				// cập nhập bảng trạng thái
				boardState.getBoardState(x, y, flag);
				//boardState.print();
				// kiểm tra tại vị trí vừa đánh xem có thắng không
				if (CheckWin.win(x, y, btn[x][y].getText(), btn)) {
					// nếu máy thắng hiển thị dialog thông báo máy thắng (X thắng)
					JOptionPane.showMessageDialog(null, "X win!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
					// hiển thị dialog hỏi có muốn chơi màn mới không
					JOptionPane.showMessageDialog(null, "Trò Chơi Mới", "Thoát", JOptionPane.INFORMATION_MESSAGE);
					//set lại cờ là người đánh trước
					flag = 1;
					// reset bàn cờ
					// n hàng
					for (int i1 = 0; i1 < n; i1++) {
						// m cột
						for (int j1 = 0; j1 < m; j1++) {
							// set lại text là rỗng
							btn[i1][j1].setText("");
							// set lại màu bàn cờ là trắng
							btn[i1][j1].setBackground(Color.white);
						}
					}
				}
			}
		}
	}
}
