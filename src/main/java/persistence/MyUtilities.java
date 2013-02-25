package persistence;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Eric
 * Date: Jun 17, 2010
 * Time: 7:29:03 PM
 */
public class MyUtilities
{
	public static boolean saveStringToFile(String fileName,
																				 String saveString)
	{
		boolean saved = false;
		BufferedWriter bw;

		try
		{
			bw = new BufferedWriter(
					new FileWriter(fileName)
			);

			try
			{
				bw.write(saveString);
				saved = true;
			}

			finally
			{
				bw.close();
			}
		}

		catch (IOException ex)
		{
			ex.printStackTrace();
		}

		return saved;
	}

	public static String getStringFromFile(String fileName)
	{
		BufferedReader br;
		StringBuilder sb = new StringBuilder();

		try
		{
			br = new BufferedReader(
					new FileReader(fileName));

			try
			{
				String s;
				while ((s = br.readLine()) != null)
				{
					// Add back linefeed since stripped by readLine()

					sb.append(s);
					sb.append("\n");
				}
			}

			finally
			{
				br.close();
			}
		}

		catch (IOException ex)
		{
			ex.printStackTrace();
		}

		return sb.toString();
	}

	public static String convertToXML(MyLibrary ml)
	{
		XStream xstream = new XStream(new DomDriver());
		xstream.setMode(XStream.ID_REFERENCES);
		xstream.alias("person", Person.class);
		xstream.alias("book", Book.class);
		xstream.alias("mylibrary", MyLibrary.class);
		return xstream.toXML(ml);
	}

	public static MyLibrary convertFromXML(String XMLString)
	{
		MyLibrary ml = null;
		XStream xstream = new XStream(new DomDriver());
		xstream.setMode(XStream.ID_REFERENCES);
		xstream.alias("person", Person.class);
		xstream.alias("book", Book.class);
		xstream.alias("mylibrary", MyLibrary.class);
		Object obj = xstream.fromXML(XMLString);
		if (obj instanceof MyLibrary)
		{
			ml = (MyLibrary) obj;
		}

		return ml;
	}

	public static boolean saveMyLibraryToXMLFile(String fileName, MyLibrary ml)
	{
		return saveStringToFile(fileName, convertToXML(ml));
	}

	public static MyLibrary getMyLibraryFromXMLFile(String fileName)
	{
		return convertFromXML(getStringFromFile(fileName));
	}

	public static boolean saveMyLibraryToSerialFile(String fileName, MyLibrary ml)
	{
		boolean saved = false;
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName)));

			// Inner try block

			try
			{
				oos.writeObject(ml);
				saved = true;
			}

			finally
			{
				oos.close();
			}
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return saved;
	}

	public static MyLibrary getMyLibraryFromSerialFile(String fileName)
	{
		MyLibrary ml = null;

		try
		{
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(fileName)));
			try
			{
				Object obj = ois.readObject();
				
				if (obj instanceof MyLibrary)
				{
					ml = (MyLibrary) obj;
				}
			}

			finally
			{
				ois.close();
			}
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return ml;
	}
}
