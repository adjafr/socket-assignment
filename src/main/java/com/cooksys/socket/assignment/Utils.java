
package com.cooksys.socket.assignment;



import com.cooksys.socket.assignment.model.Config;
import com.cooksys.socket.assignment.model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;

/**
 * Shared static methods to be used by both the {@link Client} and {@link Server} classes.
 */
public class Utils {
    /**
     * @return a {@link JAXBContext} initialized with the classes in the
     * com.cooksys.socket.assignment.model package
     */
    public static JAXBContext createJAXBContext() throws JAXBException {
        
    	
    	
    	JAXBContext context = JAXBContext.newInstance(Student.class, Config.class);
    	
    	
    	return context;
    	
    }

    /**
     * Reads a {@link Config} object from the given file path.
     *
     * @param configFilePath the file path to the config.xml file
     * @param jaxb the JAXBContext to use
     * @return a {@link Config} object that was read from the config.xml file
     */
    public static Config loadConfig(String configFilePath, JAXBContext jaxb) throws JAXBException {
        
    	
    	
    	//Config config = new Config(configFilePath);
    	Unmarshaller unmarshaller = jaxb.createUnmarshaller();
    	File file = new File(configFilePath);
    	Config config = ((Config) unmarshaller.unmarshal(file));
//   	Student info = (Student) unmarshall.unmarshal(file);
//    	student.setStudent(info);	
    	return config;
    }
    	
//    	Session sess = new Session();
//    	
//    	sess.setLocation(rootDirectory.getName());
//    	sess.setStartDate((new File("input\\memphis\\08-08-2016")).getName());
//    	sess.setInstructor(readInstructor(new File("input\\memphis\\08-08-2016\\instructor.xml"), jaxb));
//    	sess.setStudents(readStudents(new File("input\\memphis\\08-08-2016\\students"), jaxb));
//    	
//    	return sess;
    	
    	
    	
    	
    	
    }

