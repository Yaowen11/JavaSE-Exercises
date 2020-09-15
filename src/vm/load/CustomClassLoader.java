package vm.load;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author z
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = getClassFromCustomPath(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] getClassFromCustomPath(String name) {
        File file = new File("C:\\Users\\z\\IdeaProjects\\JavaSE-Exercises\\out\\production\\JavaSE-Exercises\\vm\\load");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().equals(name + ".class") && file1.isFile() && file1.exists()) {
                try {
                    byte[] bytes = new FileInputStream(file1).readAllBytes();
                    return bytes;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private byte[] loadClassFromFile(String fileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextValue;
        try {
            while ((nextValue = inputStream.read()) != -1) {
                byteArrayOutputStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteArrayOutputStream.toByteArray();
        return buffer;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Thread thread = Thread.currentThread();
        thread.setContextClassLoader(customClassLoader);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader.getClass().getName());
        Class<?> clazz = Class.forName("vm.load.One", true, customClassLoader);
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object.getClass().getClassLoader().getClass().getName());
    }
}
