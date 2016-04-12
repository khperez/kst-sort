package Sorting;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Windows extends JFrame 
{

	JTextField unsortData;
	JTextField sortedData;
	JTextField sortingName;
	public String sortName = "";
	public String unsortedText = "";
	public String sortedText = "";	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 250;

	public final int SIZE = 15;								//Size of array
	public Int[] intObj = new Int[SIZE];
	
	
	public Windows()
	{
		super("KST Array Sorting");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
				
		//Creating menu
		JMenu menu = new JMenu("Sorts");		
		
		//Generate array button on menu
		JMenuItem createArray = new JMenuItem("Generate");
		createArray.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
				//Creating random number
				Random randomGenerator = new Random();
				
				//Creating array of objects Int with random numbers
				for(int x=0; x < SIZE; x++)
				{
					intObj[x] = new Int(randomGenerator.nextInt(SIZE));
				}
				
				
				//Creating string of random numbers for display
				StringBuilder sb = new StringBuilder();
				for(int y=0; y < SIZE; y++)
				{
					sb.append(intObj[y].num);
					sb.append("  ");
				}
				
				//Update the text field of Unsorted array
				unsortedText = sb.toString();
				unsortData.setText(unsortedText);			
			}
		});
		menu.add(createArray);
		
						
		//Sorting array button using ArrayList methods
		JMenuItem arrayList = new JMenuItem("Array List");
		arrayList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(intObj == null)
				{
					JOptionPane.showMessageDialog(null, "Generate numbers first!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					//Creating an ArrayList and initialize with random numbers from array of objects Int 
					ArrayList<Integer> List = new ArrayList<>();
					for(int y=0; y < SIZE ; y++)
					{
						List.add(intObj[y].num);
					}
					
					
					//Bubble sorting using ArrayList
					//Temporary variables to hold values in List
					int num1;
					int num2;
					int temp;
					
					//Outer loop
					for(int a=1; a <= SIZE; a++)
					{
						//Inner loop
						for(int b=0; b < (SIZE-1); b++)
						{
							num1 = (int) List.get(b);
							num2 = (int) List.get(b+1);
							if(num1 > num2)
							{
								temp = num2;
								List.set((b+1), num1);
								List.set((b), temp);
							}
						}
					}
					
					
					//Creating string of sorted numbers
					StringBuilder string = new StringBuilder();
					for(int c = 0; c < SIZE; c++)
					{
						string.append(List.get(c));
						string.append("  ");
					}
					
					//Update the text field of sorted array
					sortedText = string.toString();
					sortedData.setText(sortedText);
					
					//Update the text field of Sort type
					sortName = "Array List";
					sortingName.setText(sortName);
				}				
			}
		});
		menu.add(arrayList);
		
		JMenuItem compareTo = new JMenuItem("Compare To");
		compareTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(intObj == null)
				{
					JOptionPane.showMessageDialog(null, "Generate numbers first!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					
					//Bubble sorting start
					int temp;
					for(int x=1; x <= SIZE; x++)
					{
						for(int y=0; y < (SIZE - 1); y++)
						{
							int result = intObj[y].compareTo(intObj[y+1]);
							
							if(result == 1)
							{
								temp = intObj[y+1].num;
								intObj[y+1].num = intObj[y].num;
								intObj[y].num = temp;							
							}
							else
								continue;
						}
					}
					
					//Update the text field of sorted array
					StringBuilder string = new StringBuilder();
					for(int c = 0; c < SIZE; c++)
					{
						string.append(intObj[c].num);
						string.append("  ");
					}
					
					//Update the text field of sorted array
					sortedText = string.toString();
					sortedData.setText(sortedText);
					
					//Update the text field of Sort type
					sortName = "Compare To";
					sortingName.setText(sortName);
				}
			}
		});
		menu.add(compareTo);
		
		JMenuItem precedesFol = new JMenuItem("Precedes / Follows");
		precedesFol.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(intObj == null)
				{
					JOptionPane.showMessageDialog(null, "Generate numbers first!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					//Bubble sorting start
					int temp;
					for(int x=1; x <= SIZE; x++)
					{
						for(int y=0; y < (SIZE - 1); y++)
						{
							boolean result = intObj[y].follows(intObj[y+1]);
							
							if(result == true)
							{
								temp = intObj[y+1].num;
								intObj[y+1].num = intObj[y].num;
								intObj[y].num = temp;							
							}
							else
								continue;
						}
					}
					
					//Update the text field of sorted array
					StringBuilder string = new StringBuilder();
					for(int c = 0; c < SIZE; c++)
					{
						string.append(intObj[c].num);
						string.append("  ");
					}
					
					//Update the text field of sorted array
					sortedText = string.toString();
					sortedData.setText(sortedText);
					
					//Update the text field of Sort type
					sortName = "Precedes / Follows";
					sortingName.setText(sortName);
				}
			}
		});
		menu.add(precedesFol);
		
		
		//Exit program button on menu
		JMenuItem exitProg = new JMenuItem("Exit");
		exitProg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		
		});
		menu.add(exitProg);
		
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		setJMenuBar(bar);
		
		
		
		//Panel for labels + sorted and unsorted arrays
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(3,3,1,50));
		
		//Creating label for unsorted array
		JLabel unsorted = new JLabel("Random array:  ");
		labelPanel.add(unsorted);
				
		//Display the generated random array
		unsortData = new JTextField();
		unsortData.setBackground(Color.WHITE);
		unsortData.setText(unsortedText);
		unsortData.setEditable(false);
		labelPanel.add(unsortData); 
		
		
		//Creating label for type of sorting method use to sort
		JLabel sortType = new JLabel("Sort type:  ");
		labelPanel.add(sortType);
		
		//Display sorting method name
		sortingName = new JTextField();
		sortingName.setText(sortName);
		sortingName.setEditable(false);
		labelPanel.add(sortingName);
				
		//Creating label for sorted array
		JLabel sorted = new JLabel("Sorted array:  ");
		labelPanel.add(sorted);
		
		//Display the sorted array
		sortedData = new JTextField();
		sortedData.setBackground(Color.WHITE);
		sortedData.setText(sortedText);
		sortedData.setEditable(false);
		labelPanel.add(sortedData);
		
		add(labelPanel, BorderLayout.NORTH);
		//*********************************************
		
			
		
		//Set Windows visible
		setVisible(true);
	}	
	

	
			
	
	public static void main(String[] args)
	{
		new Windows();
		
	}
}
