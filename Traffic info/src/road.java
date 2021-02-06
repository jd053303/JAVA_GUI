import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;     //java gui /java.awt/java.swing 패키지의 클래스 이용

import javax.swing.SwingConstants;

public class road extends JPanel { //extends 상속부모에서 선언/정의하고 부모의 메소드를 그대로 사용
//private 클래스 내에서만 접근이 가능
    private Object[] colum
            = {"번호","도로명 (기점<->종점)", "상태", "★"};

    private Object[][] data = {
            //경부
            {"1","경부 (양재IC<->구서IC)","원활",false},
            //남북
            {"15","서해안 (죽림JC<->금천IC)","원활",false},
            {"17","익산평택 (익산JC<->안성IC)","원활",false},
            {"25","호남 (서춘천IC<->논산IC)","원활",false},
            {"25","논산천안 (논산JC<->천안JC)","원활",false},
            {"17","순천완주 (동순천JC<->완주JC)","원활",false},
            {"29","세종포천 (세종JC<->신북IC)","원활",false},
            {"35","통영대전 (통영IC<->비룡JC)","원활",false},
            {"35","중부 (남이JC<->하남IC)","원활",false},
            {"37","제2중부 (마장JC<->산곡JC)","원활",false},
            {"45","중부내륙 (내서JC<->양평IC)","원활",false},
            {"55","중앙 (익산JC<->안성IC)","원활",false},
            {"65","동해 (동부산IC<->속초IC)","원활",false},
            //동서
            {"10","남해 (서영암IC<->덕천IC)","원활",false},
            {"12","무안광주 (무안공항IC<->운수IC)","원활",false},
            {"12","광주대구 (문흥JC<->옥포JC)","원활",false},
            {"14","함양울산 (북함양JC<->울주JC)","원활",false},
            {"16","울산 (언양JC<->울산IC)","원활",false},
            {"20","새만금포항 (새만금IC<->포항IC)","원활",false},
            {"30","당진영덕 (당진JC<->영덕IC)","원활",false},
            {"32","아산청주 (서아산IC<->오창JC)","원활",false},
            {"40","평택제천 (서평택JC<->제천JC)","원활",false},
            {"50","영동 (서창JC<->강릉JC)","원활",false},
            {"52","광주원주 (경기광주JC<->원주JC)","원활",false},
            {"60","서울양양 (강일IC<->양양IC)","원활",false},
            //순환
            {"100","수도권제1순환 (일산IC<->판교JC)","원활",false},
            {"300","대전남부 (서대전JC<->비룡JC)","원활",false},
            {"400","수도권제2순환 (화성JC<->법원IC)","원활",false},
            {"500","광주외각순환 (본량IC<->대덕JC)","원활",false},
            {"600","부산외곽순환 (진영JC<->기장JC)","원활",false},
            {"700","대구외곽순환 (구라IC<->상매JC)","원활",false},
            //경인
            {"110","경인 (서인천IC<->신월IC)","원활",false},
            {"120","제2경인 (공항신도시JC<->여수대로IC)","원활",false},
            {"130","인천공항 (신불IC<->북로JC)","원활",false},
    };
    

    private DefaultTableModel model = new DefaultTableModel(data, colum);
    private JTable list = new JTable(model);

    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(list.getModel());

    private JTextField jtfFilter = new JTextField();
    private JButton jbtFilter = new JButton("Filter");

    public road() {
    	
    	setBackground(new Color(153, 204, 204));
        setLayout(null); //절대값 좌표로 컴포넌트들을 사용

        /////////왼쪽/////////
        /////설명//
        JLabel Point = new JLabel("* [\uCCAB \uD589]\uD83D\uDDB1\uFE0F \uC624\uB984\uCC28\uC21C/\uB0B4\uB9BC\uCC28\uC21C ");
        Point.setBounds(25, 67, 290, 15); //setBounds( x, y, w, h);
        add(Point);

        ///검색///
        JPanel panel = new JPanel();
        panel.setBounds(25, 18, 221, 39);
        panel.setBackground(new Color(153, 204, 204));
        panel.setLayout(null);
        JLabel label = new JLabel("\uAC80\uC0C9");
        label.setFont(new Font("굴림", Font.BOLD, 13));
        label.setBounds(0, 10, 36, 26);
        panel.add(label);
        jtfFilter.setBounds(36, 11, 185, 26);
        panel.add(jtfFilter);
        add(panel);
        
        ///표///
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 87, 335, 483);
        add(scrollPane);
        list.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        scrollPane.setViewportView(list);
        list.setRowSorter(rowSorter);
        
        list.getColumn("★").setCellRenderer(dcr);
        JCheckBox box = new JCheckBox();
        box.setHorizontalAlignment(JLabel.CENTER);
        list.getColumn("★").setCellEditor(new DefaultCellEditor(box));
        
        ////표의 각 열의 넓이
        list.getColumn("번호").setPreferredWidth(5);
        list.getColumn("도로명 (기점<->종점)").setPreferredWidth(180);
        list.getColumn("상태").setPreferredWidth(5);
        list.getColumn("★").setPreferredWidth(5);

        //////////오른쪽/////////////////
        JLabel IMG = new JLabel("");
        IMG.setBounds(379, 87, 345, 483);
        IMG.setIcon(new ImageIcon("./img/img.jpg"));
        add(IMG);
        
        JLabel Title = new JLabel("Traffic Info");
        Title.setForeground(new Color(255, 165, 0));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("한컴 백제 M", Font.BOLD, 55));
        Title.setBounds(357, 28, 378, 47);
        add(Title);
        
        //////////////
        DefaultTableCellRenderer dtm = new DefaultTableCellRenderer();
        
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
               JFrame frame = new JFrame("Traffic info");
               frame.getContentPane().add(new road());
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//               frame.setLocationRelativeTo(null);  창이 가운데 나타나게
               frame.setVisible(true); //창을 화면에 나타낼 것인지
               frame.setSize(760,630); // 창 가로, 세로 크기
               frame.setLocation(250, 160); //창이 나타나는 위치
               frame.setResizable(false);  //창 크기 변경 X
            }

        });
    }
    
    DefaultTableCellRenderer dcr = new DefaultTableCellRenderer()
    {
     public Component getTableCellRendererComponent  // 셀렌더러
      (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
     {
      JCheckBox box= new JCheckBox();
      box.setSelected(((Boolean)value).booleanValue());  //Boolean, 참1 거짓0 
      box.setHorizontalAlignment(JLabel.CENTER); //가운데
      return box;
     }
    };
}