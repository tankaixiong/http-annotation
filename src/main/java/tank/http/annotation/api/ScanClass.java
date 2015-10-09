package tank.http.annotation.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author tank
 * @date:2015年10月9日 上午12:03:33
 * @description:
 * @version :1.0
 */
public class ScanClass {

	public static void main(String[] args) throws Exception {
		if (args.length == 0)
			return;

		File root = new File(args[0]);
		File[] files = root.listFiles();
		HashMap<String, HashMap<String, ArrayList<String>>> jarinfo = new HashMap<String, HashMap<String, ArrayList<String>>>();

		for (File file : files) {
			if (file.isDirectory() || !file.getAbsolutePath().endsWith(".jar"))
				continue;

			JarFile jar = new JarFile(file.getAbsolutePath());
			HashMap<String, ArrayList<String>> packages = new HashMap<String, ArrayList<String>>();
			Enumeration<JarEntry> entry = jar.entries();

			while (entry.hasMoreElements()) {
				JarEntry jarEntry = entry.nextElement();
				if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class"))
					continue;
				String name = jarEntry.getName().replace(".class", "").replace("/", ".");
				int pos = name.lastIndexOf(".");
				String className = name.substring(pos + 1);
				String packageName = name.substring(0, pos);

				ArrayList<String> classes = packages.get(packageName);
				if (classes == null)
					classes = new ArrayList<String>();
				classes.add(className);
				packages.put(packageName, classes);
			}

			jarinfo.put(file.getName(), packages);
		}

		// print(packages);
		printFileInfo(jarinfo);
	}

	public static void printFileInfo(HashMap<String, HashMap<String, ArrayList<String>>> fileinfo) {
		for (Entry<String, HashMap<String, ArrayList<String>>> entry : fileinfo.entrySet()) {
			System.out.println(entry.getKey());
			for (Entry<String, ArrayList<String>> entryP : entry.getValue().entrySet()) {
				System.out.println("\t" + entryP.getKey());
				for (String classname : entryP.getValue()) {
					System.out.println("\t\t" + classname);
				}
			}
		}
	}

}
