package test.aatest;

import javax.swing.*;

public class HelpDialog {
	private final JFrame parent;

	public HelpDialog(JFrame parent) {
		this.parent = parent;
	}

	public void show() {
		String message = "노노그램 게임 설명\n\n" + "1. 게임 목표\n" + "  각 행과 열의 숫자 힌트를 이용하여 보드의 셀을 숫자에 알맞게 채워 퍼즐을 완성.\n\n"
				+ "2. 게임 플레이 방법\n" + "  각 셀을 클릭하여 해당하는 셀 여러개 선택.\n" + "  검정 색깔 셀은 빈 셀이며, 흰 색 회색은 선택한 셀.\n"
				+ "  모든 행과 열의 힌트 조건을 만족할 때 퍼즐이 완성되고 초기 화면으로 돌아감.\n\n" + "3. 게임 단계\n"
				+ "  총 6개 단계로 나뉘고 순서대로 단계 해결시 다음 단계로 이동\n";
		JOptionPane.showMessageDialog(parent, message, "게임 설명", JOptionPane.INFORMATION_MESSAGE);
	}
}
