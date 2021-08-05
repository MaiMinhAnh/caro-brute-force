/**
 * Copyright(C) [2021] [Luvina Software]
 * View.java, Aug 3, 2021, AnhMTM
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PlayGame;

/**
 * lớp giao diện chính của trò chơi
 * 
 * @author AnhMTM
 *
 */
public class View extends JPanel implements ActionListener {

	/**
	 * hàm khởi tạo
	 */
	public View() {
		//phương thức thêm các component
		addComps();
	}

	private static final long serialVersionUID = 1L;

	// khai báo một main frame chứa các component
	public JFrame frame = new JFrame();
	// khai bao 5 JPanel tương ứng cho 5 miền
	// khai báo JPanle north
	JPanel panelNorth = new JPanel();
	// khai báo JPanle west
	JPanel panelWest = new JPanel();
	// khai báo JPanle east
	JPanel panelEast = new JPanel();
	// khai báo JPanle south
	JPanel panelSouth = new JPanel();
	// khai báo JPanle center
	JPanel panelCenter = new JPanel();// tạo mới 1 jpanel có tên là pan

	// khởi tạo các giá trị kích thước mảng JButton
	public int n = 20, m = 20;
	// Tạo mới 1 jbutton kiểu mảng 2 chiều có n,m phần tử
	public JButton btn[][] = new JButton[n][m];
	// của phần tử trong mảng 2 chiều

	// khởi tạo mới PlayGame thực hiện chức năng play
	PlayGame playGame = new PlayGame();

	/**
	 * thêm các phần tử component vào main frame
	 */
	public void addComps() {
		// set layout của min frame là BorderLayOut
		frame.setLayout(new BorderLayout());
		// frame.setSize(1200, 1200);
		// Tạo mới 1 JLabel là header
		JLabel lbHeader = new JLabel("GAME CARO");
		// Thêm phần header vào panel north
		panelNorth.add(lbHeader);
		// thêm panel north vào main frame
		frame.add(panelNorth, BorderLayout.NORTH);
		// thêm panel east vào main frame
		frame.add(panelEast, BorderLayout.EAST);
		// thêm panel west vào main frame
		frame.add(panelWest, BorderLayout.WEST);
		// thêm panel south vào main frame
		frame.add(panelSouth, BorderLayout.SOUTH);
		// thêm panel center vào main frame
		frame.add(panelCenter);
		// set layout của panel center là GridLayout
		panelCenter.setLayout(new GridLayout(n, m));
		// khởi tạo mảng các button để làm lưới caro
		// số hàng là n
		for (int i = 0; i < n; i++) {
			// số cột là m
			for (int j = 0; j < m; j++) {
				// khởi tạo từng button
				btn[i][j] = new JButton();
				// thêm sự kiện vào mỗi button khi người dùng click
				btn[i][j].addActionListener(this);
				// thêm JButton vào panel center
				panelCenter.add(btn[i][j]);
			}
		}
		// set màu cho các JButton
		// n hàng
		for (int i = 0; i < n; i++) {
			// m cột
			for (int j = 0; j < m; j++) {
				// set background cho mỗi button là màu trắng
				btn[i][j].setBackground(Color.white);
			}
		}
		// cài đặt khi tắt frame thì chương trình kết thúc
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// hiển thị frame
		frame.setVisible(true);
		// set kích thước của panel center
		panelCenter.setSize(700, 700);
		// set kích thước của panel east
		panelEast.setSize(50, 700);
		// set kích thước của panel west
		panelWest.setSize(50, 700);
		// set kích thước của main frame
		frame.setSize(1200, 700);
		// cài đặt người dùng không thể resize frame
		frame.setResizable(false);
	}

	/**
	 * ghi đè phương thức actionPerformed bắt sự kiện khi button được click
	 * 
	 * @param e sự kiện bắt
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// duyệt lần lượt hết bàn cờ
		// n hàng
		for (int i = 0; i < n; i++) {
			// m cột
			for (int j = 0; j < m; j++) {
				// kiểm tra xem button đc click có phải trống hay không
				if (e.getSource() == btn[i][j] && btn[i][j].getText() != "X" && btn[i][j].getText() != "O") {
					// bắt sự kiện button đc click
					playGame.play(i, j, btn);

				}
			}
		}

	}

}
