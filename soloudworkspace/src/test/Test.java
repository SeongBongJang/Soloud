package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.soloud.per.dao.MemberFriendVDAO;
import com.soloud.per.dto.MemberFriendVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;


public class Test 
{

	public static void main(String[] args)
	{

		Factory factory = DAOFactory.getInstance();
		System.out.println(1);
		/*
		FileBinarySearchDAO dao = (FileBinarySearchDAO)factory.create("FileBinary");
		
		//List<FileBinaryDTO> list = dao.selectAllFileBinary();
		FileBinaryDTO dto = dao.selectFileBinaryCode("fb2");
		
		List<FileBinaryDTO> list = new ArrayList<FileBinaryDTO>();
		list.add(dto);
		
		*/
		File f = new File("C:/Users/BK/Pictures/pic/3.jpg");
		InputStream is=null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberFriendVDAO dao = (MemberFriendVDAO) factory.create("MemberFriendView");
		
		//Object res = dao.insertFileBinary("fi1", is, (int)(file.length()));
		
		List<MemberFriendVDTO> list = dao.searchMemberFriend("m1");
		
		printList(list);
		
	}
	public static void printList(Object list)
	{
	
		Iterator<Object> iter = ((List<Object>)list).iterator();
			
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}

			/*
		while(iter.hasNext())
		{
			
			BufferedOutputStream os=null;
			try {
				FileBinaryDTO dto = (FileBinaryDTO) iter.next();
				
				os = new BufferedOutputStream(new FileOutputStream("C:/Users/BK/Documents/hello/" + dto.getFileCode().trim() + ".jpg"));
				InputStream is = (InputStream)dto.getFileBinary();
				//int size = dto.getSize();
				
				byte[] buffer = new byte[1024];
				int length = -1;
				while((length = is.read(buffer)) != -1){
	               // System.out.println("∑Á«¡µº");
					os.write(buffer, 0, length);
				}
				os.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
		*/
	}



}
