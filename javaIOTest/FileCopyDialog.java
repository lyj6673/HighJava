package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileCopyDialog {
	public static void main(String[] args) {
		
	}
	
	//시작 메서드
	public void fileCopyStart() {
		File sourceFile = showDialog("OPEN");
		
		if(sourceFile==null) {
			System.out.println("복사할 원본 파일이 선택되지 않았습니다");
			System.out.println("복사 작업 중지");
			return;
		}
		
		if(!sourceFile.exists()) {
			System.out.println(sourceFile.getPath() + "파일이 없습니다.");
			System.out.println("복사 작업을 마칩니다");
			return;
		}
		
		File targetFile = showDialog("SAVE");
		if(targetFile==null) {
			System.out.println("대상 파일이 선택되지 않았습니다");
			System.out.println("복사 작업 중지");
			return;
		}
		
		try {
			//복사할 원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fin = new FileInputStream(sourceFile);
			
			// 대상 파일로 저장할 스트림 객체 생성
			FileOutputStream fout =
					new FileOutputStream("d:/d_other/연습용/복사본_코알라.jpg");
			
			System.out.println("복사 작업 시작");
			
			int data;	//읽어온 데이터를 저장할 변수
			
			while((data = fin.read()) != -1) {
				fout.write(data);
			}
			
			//스트림 닫기
			fout.close();
			fin.close();
			System.out.println("복사작업 끝");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public File showDialog(String option) {
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
				
				int result;
				//창 보여주기
				if("OPEN".equals(option.toUpperCase())) {
					result = chooser.showOpenDialog(new Panel()); //열기용
				}else if("SAVE".equals(option.toUpperCase())){
					result = chooser.showSaveDialog(new Panel()); //저장용
				}else {
					System.out.println("option 매개변수에는 'OPEN' 또는 'SAVE'만 사용하세요");
					return null;
				}
				
				File selectedFile = null;
				//보여진 창에서 파일을 선택한 후 '열기' 또는 '저장' 버튼을 눌렀을 경우 처리하기
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					System.out.println("선택한 파일 :"+selectedFile.getAbsolutePath());
				}
	}
}
