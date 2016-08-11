package com.cooksys.socket.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import javax.xml.bind.Unmarshaller;

import com.cooksys.socket.assignment.model.Config;

public class Client
{

	public static void main(String[] args)
	{

		try
		{
			JAXBContext context = Utils.createJAXBContext();
			Config config = Utils.loadConfig("config/config.xml", context);
			
			try (
					Socket s = new Socket(config.getRemote().getHost(), config.getLocal().getPort());
					InputStream in = s.getInputStream();
					)
			{
				Unmarshaller unmarshaller = context.createUnmarshaller();

				System.out.println(unmarshaller.unmarshal(in));

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
