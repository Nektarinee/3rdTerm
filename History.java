package client;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class History
{
    private static PrintWriter printWriter;
    private static String getHistoryByLogin(String login)
    {
        return "history/history_" + login +".txt";
    }

    public static void start(String login) throws FileNotFoundException {
        printWriter = new PrintWriter(new FileOutputStream(getHistoryByLogin(login),true));
    }

    public static void WriteToHistory(String message)
    {
        printWriter.println(message);
    }
    public static String getAndPrintLast100Messages(String login) throws IOException {
        if (!Files.exists(Paths.get(getHistoryByLogin(login))))
        {
            return login;
        }
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(getHistoryByLogin(login), "r")) {
            long startIdx = getHistoryByLogin(login).length();
            while (startIdx >= 0 && (result == null || result.length() == 0)) {
                raf.seek(startIdx);
                if (startIdx > 0)
                    raf.readLine();
                result = raf.readLine();
                startIdx--;
            }
        }
        return result;

    }

    public static void stopHistory()
    {
        printWriter.close();
    }


}

