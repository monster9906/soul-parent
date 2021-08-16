package com.xnx3.wuye.client.ui;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Font;

/**
 * 打印预览 + 打印<br/>
 * 一行代码使用：
 * 	<pre>new PrintJframe().printPreview("/Users/apple/git/wuyeclient/cache/dianfeishouju_1569658816/");</pre>
 * 传入要打印的文件所在的文件夹，会自动便利这个文件夹下所有的文件进行打印。<br/>
 * 注意，只能打印图片png格式文件
 *
 * @author 管雷鸣 www.guanleiming.com
 */
public class PrintJframe extends JFrame {
    private JPanel contentPane;
    JPanel drawPanel;
    private JScrollPane scrollPane;
    JPanel panel;	//图片都是放到这个panel中
    List<String> pathList = new ArrayList<String>();
    private JLabel numberLabel;	//右上角的label，显示总共多少页
    private JButton printAllButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new PrintJframe().printPreview("/Users/apple/git/wuyeclient/cache/dianfeishouju_1569658816/");
    }

    /**
     * Create the frame.
     */
    public PrintJframe() {
        setTitle("打印预览");
        setBounds(100, 100, 715, 532);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        drawPanel = new JPanel();

        JPanel panel_1 = new JPanel();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(drawPanel, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(0)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addComponent(drawPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                                .addGap(0))
        );

        printAllButton = new JButton("全部打印");
        printAllButton.setVisible(false);
        printAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pathList.size() == 0){
                    JOptionPane.showMessageDialog(null, "<html>没有需要打印的图片，无需打印");
                    return;
                }

                //进行打印
                try {
                    print();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "<html>打印出现异常：<br/>"+e1.getMessage());
                } catch (PrintException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "<html>打印出现异常：<br/>"+e1.getMessage());
                }

            }
        });

        numberLabel = new JLabel("加载中...");
        numberLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(numberLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(printAllButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(printAllButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(382, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        contentPane.setLayout(gl_contentPane);
        drawPanel.setLayout(new CardLayout(0, 0));

        scrollPane = new JScrollPane();
        drawPanel.add(scrollPane, "name_432199223362");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(panel);

//		panel.revalidate();
    }

    /**
     * 增加一页
     * @param path 图片路径，格式如 /Users/apple/git/wuyeclient/cache/dianfeishouju_1569658990/20.png
     */
    public void addPage(String path){
        pathList.add(path);
        PageJPanel page = new PageJPanel(path);
        panel.add(page);
        panel.add(new FengexianJPanel(pathList.size(), new File(path)));
        numberLabel.setText("<html>正在加载中...<br/>已加载 "+pathList.size()+" 页");
    }

    /**
     * 图片加完了，没有再加的图片路径了，执行此
     */
    public void loadFinish(){
        numberLabel.setText("<html>加载完毕<br/>共计 "+pathList.size()+" 页");
        printAllButton.setVisible(true);
    }


    /**
     * 打印预览
     * @param path 图片所在的文件夹，这是文件夹，会自动将这个文件夹下所有png格式文件加载进打印预览中。传入格式如： /Users/apple/git/wuyeclient/cache/dianfeishouju_1569658990/
     */
    public void printPreview(String path){
        this.setVisible(true);

        File file = new File(path);
        if(!file.exists()){
            JOptionPane.showMessageDialog(null, "<html>文件夹不存在!<br/>"+path);
        }

        //读取文件夹内的文件
        File subFiles[] = file.listFiles();

        //按照文件名进行排序
        List<File> fileList = Arrays.asList(subFiles);
        Collections.sort(fileList, new Comparator<File>() {
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile()){
                    return -1;
                }
                if (o1.isFile() && o2.isDirectory()){
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        //将排序好的结果，也就是图片子文件，加入到打印预览中去，每个文件都是一页
        for (int i = 0; i < fileList.size(); i++) {
            if(subFiles[i].isFile() && subFiles[i].length() > 1000){
                addPage(subFiles[i].getPath());
            }
        }

        //加载完成标注
        loadFinish();
    }

    /**
     * 进行打印操作，打印 png 格式图片
     * @throws IOException
     * @throws PrintException
     */
    public void print() throws IOException, PrintException{
        System.setProperty("java.awt.headless","false");
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//		pras.add(MediaSize.);	//A4打印
        pras.add(MediaSizeName.ISO_A4);
        pras.add(new Copies(1)); //份数
        pras.add(OrientationRequested.PORTRAIT);// 设置成竖打 (高>宽)
//		pras.add(OrientationRequested.LANDSCAPE);	//横向正常打印
        // 设定打印区域大小，使上下左右边距都是5mm
        MediaPrintableArea mp = new MediaPrintableArea(5f, 5f, 200f, 287f, Size2DSyntax.MM);
        pras.add(mp);

        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.PNG;	//TEXT_HTML_UTF_8 win7不能用
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

        //测试打印机支持什么类型打印
//		try {
//			DocFlavor dfs[] = defaultService.getSupportedDocFlavors();
//			for (int i = 0; i < dfs.length; i++) {
//				System.out.println("support ----- "+dfs[i].getMediaType()+",  "+dfs[i].getMimeType());
//			}
//		} catch (Exception e) {
//		}

        PrintService service;
        if(defaultService != null){
            service = defaultService;
            System.out.println("使用默认打印机进行打印："+defaultService.getName());
        }else if(printService.length > 0){
            service = ServiceUI.printDialog(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(), 200, 200,
                    printService, defaultService, flavor, pras);
        }else{
            JOptionPane.showMessageDialog(null, "程序未能发现系统打印机！");
            return;
        }


        if (service != null) {
            System.out.println("print -- "+service.getName());
            if(!service.isDocFlavorSupported(flavor)){
                System.err.println("The printer does not support the appropriate DocFlavor");
            }

            for (int i = 0; i < pathList.size(); i++) {
                DocPrintJob job = service.createPrintJob();
                File file = new File(pathList.get(i));
                FileInputStream fis = new FileInputStream(file);
                DocAttributeSet das = new HashDocAttributeSet();
                das.add(new MediaPrintableArea(0,0,55,90,MediaPrintableArea.MM));
                Doc document = new SimpleDoc(fis, flavor, das);
                job.print(document, pras);
            }
        }
    }
}

/**
 * 一个 PageJPanel 便是一页
 * @author 管雷鸣
 *
 */
class PageJPanel extends JPanel{
    private ImageIcon imageicon;

    /**
     * @param path 图片路径，如 /Users/apple/git/wuyeclient/cache/dianfeishouju_1569658990/20.png
     */
    public PageJPanel(String path) {
        imageicon=new ImageIcon(path);
        imageicon = change(imageicon, 0.2);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        imageicon.paintIcon(this, g, 0, 0);
    }
    public Dimension getPreferredSize(){
        return new Dimension(imageicon.getIconWidth(),imageicon.getIconHeight());
    }

    /**
     * 图片缩放
     * @param i 缩放比例，如 0.2
     */
    public ImageIcon change(ImageIcon image,double i){//  i 为放缩的倍数
        int width=(int) (image.getIconWidth()*i);
        int height=(int) (image.getIconHeight()*i);
//		image.SCALE_SMOOTH //平滑优先
//		image.SCALE_FAST//速度优先
        Image img=image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);//第三个值可以去查api是图片转化的方式
        ImageIcon image2=new ImageIcon(img);
        return image2;
    }
}

/**
 * 每页中间的横线，分割线
 * @author 管雷鸣
 *
 */
class FengexianJPanel extends JPanel{
    private int number;	//当前页码，第几页
    private File file;
    public FengexianJPanel(int number, File file) {
        this.number = number;
        this.file = file;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("第 "+this.number+" 页，文件名："+this.file.getName(), 300, 40);
        g.drawLine(0, 65, 800, 65);
    }
    public Dimension getPreferredSize(){
        return new Dimension(800,100);
    }
}