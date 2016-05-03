package misc;

import java.io.File;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Test-Aufruf-Beispiele (der letzte Aufruf mit junit-...jar im Classpath):
 * java classfinder.ClassFinder
 * java classfinder.ClassFinder classfinder
 * java classfinder.ClassFinder "" classfinder.MeinInterface
 * java classfinder.ClassFinder "" classfinder.MeineAbstrakteKlasse
 * java classfinder.ClassFinder "" org.junit.runner.Result
 */
public class ClassFinder
{
    // Die main()-Methode ist hauptsächlich für Tests:
    public static void main (String[] args) throws Exception
    {
        String packageName = "com.basic.statement"; //( args.length > 0 ) ? args[0] : null;
        System.out.println("\n---- Gefundene Klassen:");
        List<Class<?>> classes = getClasses(packageName);
        classes.forEach(System.out::println);
    }

    // Finde Klassen (über Interface oder Klasse bzw. Package-Namen):
    public static List<Class<?>> getClasses (String packageName)
    {
        List<Class<?>> classes = new ArrayList<>();
        for (String path : getPathesFromClasspath())
        {
            File fileOrDir = new File(path);
            if (fileOrDir.isDirectory())
            {
                classes.addAll(getClassesFromDir(fileOrDir, packageName));
            }
            if (fileOrDir.isFile() && (fileOrDir.getName().toLowerCase().endsWith(".jar") ||
                    fileOrDir.getName().toLowerCase().endsWith(".zip")))
            {
                classes.addAll(getClassesFromJar(fileOrDir, packageName));
            }
        }
        return Collections.unmodifiableList(classes);
    }

    public static List<String> getPathesFromClasspath ()
    {
        String classpath = System.getProperty("java.class.path");
        String pathseparator = System.getProperty("path.separator");
        StringTokenizer tokenizer = new StringTokenizer(classpath, pathseparator);
        List<String> pathes = new ArrayList<>();
        while (tokenizer.hasMoreElements())
        {
            pathes.add(tokenizer.nextToken());
        }
        return Collections.unmodifiableList(pathes);
    }

    public static List<Class<?>> getClassesFromJar (File file, String packageName)
    {
        if (packageName == null)
        {
            packageName = "";
        }
        List<Class<?>> classes = new ArrayList<>();
        String dirSearched = packageName.replace(".", "/");
        ZipFile zipFile = null;
        try
        {
            zipFile = new ZipFile(file);
        }
        catch (Exception ex)
        {
            // nur Dateien, die gezippt sind und geöffnet werden können, sind interessant
            return classes;
        }
        for (Enumeration<? extends ZipEntry> zipEntries = zipFile.entries(); zipEntries.hasMoreElements(); )
        {
            String entryName = zipEntries.nextElement().getName();
            if (!entryName.startsWith(dirSearched) ||
                    !entryName.toLowerCase().endsWith(".class"))
            {
                continue;
            }
            entryName = entryName.substring(0, entryName.length() - ".class".length());
            entryName = entryName.replace("/", ".");
            try
            {
                Class<?> clazz = Class.forName(entryName);
                classes.add(clazz);
            }
            catch (Throwable ex)
            {
                // nur 'verwendbare' Klassen sind interessant
            }
        }
        try
        {
            zipFile.close();
        }
        catch (Exception ex)
        { /* wird ignoriert */ }
        return Collections.unmodifiableList(classes);
    }

    public static List<Class<?>> getClassesFromDir (File dir, String packageName)
    {
        if (packageName == null)
        {
            packageName = "";
        }
        List<Class<?>> classes = new ArrayList<>();
        File dirSearched = new File(dir.getPath() + File.separator + packageName.replace(".", "/"));
        if (dirSearched.isDirectory())
        {
            getClassesFromFileOrDirIntern(true, dirSearched, packageName, null, classes);
        }
        return Collections.unmodifiableList(classes);
    }

    private static void getClassesFromFileOrDirIntern (boolean first, File fileOrDir, String packageName,
                                                       Class<?> classSearched, List<Class<?>> classes)
    {
        if (fileOrDir.isDirectory())
        {
            if (!first)
            {
                packageName = (packageName + "." + fileOrDir.getName()).replaceAll("^\\.", "");
            }
            for (String subFileOrDir : fileOrDir.list())
            {
                getClassesFromFileOrDirIntern(false, new File(fileOrDir, subFileOrDir),
                        packageName, classSearched, classes);
            }
        }
        else
        {
            if (fileOrDir.getName().toLowerCase().endsWith(".class"))
            {
                String classFile = fileOrDir.getName();
                classFile = packageName + "." + classFile.substring(0, classFile.length() - ".class".length());
                try
                {
                    Class<?> clazz = Class.forName(classFile);
                    if (classSearched == null || classSearched.isAssignableFrom(clazz))
                    {
                        classes.add(clazz);
                    }
                }
                catch (Throwable ex)
                {
                    // nur 'verwendbare' Klassen sind interessant
                }
            }
        }
    }
}
