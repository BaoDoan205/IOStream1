package IOStream;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class IOStream_Bai2 extends JFrame{

	public IOStream_Bai2(){
		this.setTitle("Delete File");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel jPanel_file = new JPanel();
		jPanel_file.setLayout(new FlowLayout());
		JLabel jLabel_file = new JLabel("File");
		JTextField jTextField_file = new JTextField(20);
		jPanel_file.add(jLabel_file);
		jPanel_file.add(jTextField_file);
		
		JPanel jPanel_but = new JPanel();
		jPanel_but.setLayout(new GridLayout(1, 2, 20, 20));
		
		JButton jButton_chon = new JButton("Choose");
		JButton jButton_xoa = new JButton("Delete");
	
		jPanel_but.add(jButton_chon);
		jPanel_but.add(jButton_xoa);
		
		jButton_chon.addActionListener(new ActionListener() {
			
			private Component IOStream_Bai2;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser choose = new JFileChooser();
				choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int result = choose.showOpenDialog(IOStream_Bai2);
				if(result == JFileChooser.APPROVE_OPTION) {
					String path = choose.getSelectedFile().getAbsolutePath();
					jTextField_file.setText(path);
					
				}
			}
		});
		
		jButton_xoa.addActionListener(new ActionListener() {
			
			private Component IOStream_Bai2;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField_file.setText("");
				int option = JOptionPane.showConfirmDialog(IOStream_Bai2, "Are you sure delete all items?");
				if(option == JOptionPane.NO_OPTION) return;
				
				String path = jTextField_file.getText();
				deleteFile(path);
			}

			private void deleteFile(String path) {
				// TODO Auto-generated method stub
				try {
					
				    File myFile = new File(path);
				    if(myFile.isDirectory()) {
				    	for(File f : myFile.listFiles()) {
				    		deleteFile(f.getAbsolutePath());
				    	}
				    }else {
				    	//Xóa bản thân nó
					    myFile.delete();
				    }
				       
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_file, BorderLayout.CENTER);
		this.add(jPanel_but, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    new IOStream_Bai2();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}
