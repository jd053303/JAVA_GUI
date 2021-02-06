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
import java.awt.Component;     //java gui /java.awt/java.swing ��Ű���� Ŭ���� �̿�

import javax.swing.SwingConstants;

public class road extends JPanel { //extends ��Ӻθ𿡼� ����/�����ϰ� �θ��� �޼ҵ带 �״�� ���
//private Ŭ���� �������� ������ ����
    private Object[] colum
            = {"��ȣ","���θ� (����<->����)", "����", "��"};

    private Object[][] data = {
            //���
            {"1","��� (����IC<->����IC)","��Ȱ",false},
            //����
            {"15","���ؾ� (�׸�JC<->��õIC)","��Ȱ",false},
            {"17","�ͻ����� (�ͻ�JC<->�ȼ�IC)","��Ȱ",false},
            {"25","ȣ�� (����õIC<->���IC)","��Ȱ",false},
            {"25","���õ�� (���JC<->õ��JC)","��Ȱ",false},
            {"17","��õ���� (����õJC<->����JC)","��Ȱ",false},
            {"29","������õ (����JC<->�ź�IC)","��Ȱ",false},
            {"35","�뿵���� (�뿵IC<->���JC)","��Ȱ",false},
            {"35","�ߺ� (����JC<->�ϳ�IC)","��Ȱ",false},
            {"37","��2�ߺ� (����JC<->���JC)","��Ȱ",false},
            {"45","�ߺγ��� (����JC<->����IC)","��Ȱ",false},
            {"55","�߾� (�ͻ�JC<->�ȼ�IC)","��Ȱ",false},
            {"65","���� (���λ�IC<->����IC)","��Ȱ",false},
            //����
            {"10","���� (������IC<->��õIC)","��Ȱ",false},
            {"12","���ȱ��� (���Ȱ���IC<->���IC)","��Ȱ",false},
            {"12","���ִ뱸 (����JC<->����JC)","��Ȱ",false},
            {"14","�Ծ��� (���Ծ�JC<->����JC)","��Ȱ",false},
            {"16","��� (���JC<->���IC)","��Ȱ",false},
            {"20","���������� (������IC<->����IC)","��Ȱ",false},
            {"30","�������� (����JC<->����IC)","��Ȱ",false},
            {"32","�ƻ�û�� (���ƻ�IC<->��âJC)","��Ȱ",false},
            {"40","������õ (������JC<->��õJC)","��Ȱ",false},
            {"50","���� (��âJC<->����JC)","��Ȱ",false},
            {"52","���ֿ��� (��Ɽ��JC<->����JC)","��Ȱ",false},
            {"60","������ (����IC<->���IC)","��Ȱ",false},
            //��ȯ
            {"100","��������1��ȯ (�ϻ�IC<->�Ǳ�JC)","��Ȱ",false},
            {"300","�������� (������JC<->���JC)","��Ȱ",false},
            {"400","��������2��ȯ (ȭ��JC<->����IC)","��Ȱ",false},
            {"500","���ֿܰ���ȯ (����IC<->���JC)","��Ȱ",false},
            {"600","�λ�ܰ���ȯ (����JC<->����JC)","��Ȱ",false},
            {"700","�뱸�ܰ���ȯ (����IC<->���JC)","��Ȱ",false},
            //����
            {"110","���� (����õIC<->�ſ�IC)","��Ȱ",false},
            {"120","��2���� (���׽ŵ���JC<->�������IC)","��Ȱ",false},
            {"130","��õ���� (�ź�IC<->�Ϸ�JC)","��Ȱ",false},
    };
    

    private DefaultTableModel model = new DefaultTableModel(data, colum);
    private JTable list = new JTable(model);

    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(list.getModel());

    private JTextField jtfFilter = new JTextField();
    private JButton jbtFilter = new JButton("Filter");

    public road() {
    	
    	setBackground(new Color(153, 204, 204));
        setLayout(null); //���밪 ��ǥ�� ������Ʈ���� ���

        /////////����/////////
        /////����//
        JLabel Point = new JLabel("* [\uCCAB \uD589]\uD83D\uDDB1\uFE0F \uC624\uB984\uCC28\uC21C/\uB0B4\uB9BC\uCC28\uC21C ");
        Point.setBounds(25, 67, 290, 15); //setBounds( x, y, w, h);
        add(Point);

        ///�˻�///
        JPanel panel = new JPanel();
        panel.setBounds(25, 18, 221, 39);
        panel.setBackground(new Color(153, 204, 204));
        panel.setLayout(null);
        JLabel label = new JLabel("\uAC80\uC0C9");
        label.setFont(new Font("����", Font.BOLD, 13));
        label.setBounds(0, 10, 36, 26);
        panel.add(label);
        jtfFilter.setBounds(36, 11, 185, 26);
        panel.add(jtfFilter);
        add(panel);
        
        ///ǥ///
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 87, 335, 483);
        add(scrollPane);
        list.setFont(new Font("���� ���", Font.PLAIN, 12));
        scrollPane.setViewportView(list);
        list.setRowSorter(rowSorter);
        
        list.getColumn("��").setCellRenderer(dcr);
        JCheckBox box = new JCheckBox();
        box.setHorizontalAlignment(JLabel.CENTER);
        list.getColumn("��").setCellEditor(new DefaultCellEditor(box));
        
        ////ǥ�� �� ���� ����
        list.getColumn("��ȣ").setPreferredWidth(5);
        list.getColumn("���θ� (����<->����)").setPreferredWidth(180);
        list.getColumn("����").setPreferredWidth(5);
        list.getColumn("��").setPreferredWidth(5);

        //////////������/////////////////
        JLabel IMG = new JLabel("");
        IMG.setBounds(379, 87, 345, 483);
        IMG.setIcon(new ImageIcon("./img/img.jpg"));
        add(IMG);
        
        JLabel Title = new JLabel("Traffic Info");
        Title.setForeground(new Color(255, 165, 0));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("���� ���� M", Font.BOLD, 55));
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
//               frame.setLocationRelativeTo(null);  â�� ��� ��Ÿ����
               frame.setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������
               frame.setSize(760,630); // â ����, ���� ũ��
               frame.setLocation(250, 160); //â�� ��Ÿ���� ��ġ
               frame.setResizable(false);  //â ũ�� ���� X
            }

        });
    }
    
    DefaultTableCellRenderer dcr = new DefaultTableCellRenderer()
    {
     public Component getTableCellRendererComponent  // ��������
      (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
     {
      JCheckBox box= new JCheckBox();
      box.setSelected(((Boolean)value).booleanValue());  //Boolean, ��1 ����0 
      box.setHorizontalAlignment(JLabel.CENTER); //���
      return box;
     }
    };
}