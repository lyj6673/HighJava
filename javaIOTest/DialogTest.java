package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {
	public static void main(String[] args) {
		// SWING의 파일 열기 창, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		//선택할 파일 확장자 설정
		FileNameExtensionFilter txt = 
				new FileNameExtensionFilter("텍스트문서(*.txt)", "txt");
		
		FileNameExtensionFilter img = 
				new FileNameExtensionFilter("이미지 파일",
						new String[] {"jpg", "png", "gif"});
		
		FileNameExtensionFilter doc = 
				new FileNameExtensionFilter("MS Word 파일", "doc", "docx");
		
		//'모든 파일' 목록 표시 여부 설정하기 (true : 나타남, false : 나타나지 않음)
		chooser.setAcceptAllFileFilterUsed(true);
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		//확장자 목록 중 기본
		
		// Dialog 창이 나타낼 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		//창 보여주기
		int result = chooser.showOpenDialog(new Panel()); //열기용
		//int result = chooser.showSaveDialog(new Panel()); //저장용
		
		//보여진 창에서 파일을 선택한 후 '열기' 또는 '저장' 버튼을 눌렀을 경우 처리하기
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일 :"+selectedFile.getAbsolutePath());
		}
	}
}
