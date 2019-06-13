package sy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Counter extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	//实现序列化类的不同版本间的兼容性
	int i;
	private final String[] str = { "+", "-", "*", "1", "2", "3", "/",
	"4", "5", "6", "=", "7", "8", "9", "0" };
	//定义数组并初始化
	JButton[] buttons = new JButton[str.length];// 实例化一个按钮长度
	JButton button = new JButton("CE");// 添加一个CE按钮
	JTextField text = new JTextField();// 实例化一个文本输入框

	public Counter() {
		super("我的计算器");//添加标题
		JPanel panel = new JPanel(new GridLayout(4, 4));// 实例化一个4*4的网络布局
		panel.add("North", button);// 将button添加到北方
		for (i = 0; i < str.length; i++) {
			buttons[i] = new JButton(str[i]);//将str中的字符添加到按钮中
			if(i==14)
				buttons[i].setBackground(Color.orange);
			//将0设置为橙色
			else if (i<3)
			buttons[i].setBackground(Color.gray);
			//将+号 -号 *号设置为灰色
			else if((i+2)%4!=0)
				buttons[i].setBackground(Color.orange);
			//将1——9设置为橙色
			else buttons[i].setBackground(Color.gray);
			//将/号  =号设置为灰色
			panel.add(buttons[i]);
		} // 将数组str中的字符依次添加到网络布局的按钮中
		JPanel panel1 = new JPanel(new BorderLayout());// 实例化一个边框布局
		panel1.add("Center", text);// 将text添加到中间

		getContentPane().setLayout(new BorderLayout());// 将内容面板的布局方式设置为边框布局
		getContentPane().add("North", panel1);// 将panel1添加到内容面板的北部
		getContentPane().add("Center", panel);// 将panel添加到内容面板的中部
		for (i = 0; i < str.length; i++)
			buttons[i].addActionListener(this);// 添加实现按钮的监听
		button.addActionListener(this);// 添加实现button的监听
		text.addActionListener(this);// 添加实现文本内容的监听
		setSize(450, 400);// 设置窗口的大小为400*300像素
		setVisible(true);//使窗口可见
	}

	public void actionPerformed(ActionEvent e) {
		Object f = e.getSource();// 获取事件按钮对象
		String label = e.getActionCommand();// 获取事件中的按钮值
		if (f == button)
			handleReset();// 如果f=button，执行handleReset方法
		else if ("0123456789.".indexOf(label) >= 0)
			handleNumber(label);// 如果label是数字0123456789.中的一个则执行handleNumber方法
		else
			handleOperator(label);// 否则执行handleOperator方法
	}

	boolean data = true;// 定义一个布尔型的data对象

	public void handleNumber(String key) {
		if (data)
			text.setText(key);// 如果data为真，则取代之前的0
		else if ((key.equals(".")) && (text.getText().indexOf(".") <= 0))
			text.setText(text.getText() + ".");
		// 否则key=.与取值为小于0的值就给文本内容加一个.
		else if (!key.equals("."))
			text.setText(text.getText() + key);
		// 否则如果key不等于.就把key添加到文本中
		data = false;// 否则错误
	}

	double result = 0.0;// 定义一个结果对象result为双精度浮点型并赋值为0.0
	String operator = "=";// 定义一个操作对象operator并赋值为=

	public void handleReset() {
		text.setText("0");// 将文本框清零
		data = true;// data的布尔值赋为true
	}

	public void handleOperator(String key) {
		//代填
		else if (operator.equals("/"))
			result /= Double.valueOf(text.getText());
	// 如果operator等于=“/”，result=result/得到的已转换为双精度浮点型的文本值

	}

	public static void main(String[] args) {
		new Counter();// 将Counter类中的内容传到main中
	}
}
 
