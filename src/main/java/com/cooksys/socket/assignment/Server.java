package com.cooksys.socket.assignment;

import com.cooksys.socket.assignment.model.Config;
import com.cooksys.socket.assignment.model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Server extends Utils
{

	/**
	 * Reads a {@link Student} object from the given file path
	 *
	 * @param studentFilePath
	 *            the
	 * @param jaxb
	 * @return
	 */
	public static Student loadStudent(String studentFilePath, JAXBContext jaxb) throws JAXBException
	{

		File file = new File(studentFilePath);
		Unmarshaller unmarshall = jaxb.createUnmarshaller();
		Student info = (Student) unmarshall.unmarshal(file);
		// student.setStudent(info);
		return info;
	}

	public static void main(String[] args)
	{

		try
		{
			JAXBContext context = Utils.createJAXBContext();
			Config config = Utils.loadConfig("config/config.xml", context);
			Student stud = loadStudent(config.getStudentFilePath(), context);

			try (ServerSocket ss = new ServerSocket(config.getLocal().getPort());
					Socket s = ss.accept();

					OutputStream out = s.getOutputStream();

			)
			{
				Marshaller marshaller = context.createMarshaller();// convert to
																	// xml
				marshaller.marshal(stud, out);

			} catch (IOException e)
			{
				e.printStackTrace();

			}
		} catch (JAXBException e)

		{
			e.printStackTrace();

		}

	}
}
