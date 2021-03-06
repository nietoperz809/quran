package twitter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import misc.StringDivider;
import misc.Tools;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/*
 Application Settings
 
 Consumer Key (API Key) ids0SNNX2nXzOkyalerKqjuYk
 Consumer Secret (API Secret) ejFqASN5ilEIleFzKHWm3asDMPZaOd0AOREoLxzZTocQFeGT2N 

 Access Token 726420120-fexM4zPAJETnVNiJnr8goS5zMCua59iCGAQYQkGx
 Access Token Secret Z7tbJ2vPndjxNu3QJlGJlOkhpnUKhLxFbwsTVxI014MU8 
 */
/**
 *
 * @author Administrator
 */
public class TwitTools implements TwitterKeys
{
    static private TwitTools m_instance = null;
    static private Twitter m_twit;

    private TwitTools()
    {
        try
        {
            //m_twit = connect("diobmohr", "mxyzptlk");
            m_twit = connect();
        }
        catch (TwitterException | IOException ex)
        {
            m_twit = null;
        }
    }

    public static TwitTools get()
    {
        if (m_instance == null)
        {
            m_instance = new TwitTools();
        }
        return m_instance;
    }

//    private Twitter connect(String user, String pass) throws TwitterException, IOException
//    {
//        Configuration configuration = new ConfigurationBuilder()
//                .setOAuthConsumerKey(consumerKey)
//                .setOAuthConsumerSecret(consumerSecret)
//                .build();
//
//        Twitter twitter = new TwitterFactory(configuration).getInstance(new BasicAuthorization(user, pass)); // yes, use "BasicAuthorization" although that seems strange
//        return twitter;
//    }
    private Twitter connect() throws TwitterException, IOException
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessKey);
        cb.setOAuthAccessTokenSecret(accessSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;
    }

    private File toFile(BufferedImage img) throws Exception
    {
        File file = File.createTempFile("twittools", ".tmp");
        ImageIO.write(img, "png", file);
        return file;
    }

    private File toFile(InputStream in) throws Exception
    {
        File file = new File("tempfile");
        Files.copy(in, file.toPath());
        return file;
    }

    private void sendFile(File f, String label) throws Exception
    {
        if (label == null)
            label = "";
        StatusUpdate st = new StatusUpdate(label);
        st.setMedia(f);
        synchronized (m_twit)
        {
            m_twit.updateStatus(st);
        }
    }

    public void send(BufferedImage img, String label) throws Exception
    {
        if (m_twit == null)
        {
            return;
        }
        File f = toFile(img);
        sendFile(f, label);
    }

    public void sendAsync (final BufferedImage img, final String label)
    {
        Runnable r = () ->
        {
            try
            {
                send (img, label);
            }
            catch (Exception ex)
            {
                Logger.getLogger(TwitTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        Tools.execute(r);
    }
    
    public void send(InputStream in, String label) throws Exception
    {
        if (m_twit == null)
        {
            return;
        }
        File f = toFile(in);
        sendFile(f, label);
    }

    public void sendStringArray(String[] sa) throws Exception
    {
        if (m_twit == null)
        {
            return;
        }

        for (String s : sa)
        {
            synchronized (m_twit)
            {
                Status st = m_twit.updateStatus(s);
            }
        }
    }

    public static void sendLongString(String str)
    {
        StringDivider sd = new StringDivider(str);
        String[] div = sd.splitByWords();
        TwitTools tw = TwitTools.get();
        try
        {
            tw.sendStringArray(div);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static void sendLongStringAsync (final String str)
    {
        Runnable r = () ->
        {
            sendLongString(str);
        };
        Tools.execute(r);
    }

    public void sendAsync (final String str)
    {
        Runnable r = () ->
        {
            try
            {
                m_twit.updateStatus(str);
            }
            catch (TwitterException e)
            {
                e.printStackTrace();
            }
        };
        Tools.execute(r);
    }

    public static List<Status> getTimeLine()
    {
        TwitTools tw = TwitTools.get();
        try
        {
            return TwitTools.m_twit.getHomeTimeline();
        }
        catch (Exception ex)
        {
          return null;
        }
    }
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws Exception
//    {
//        final String islamText
//            = "Oh mankind! Listen well to what I say. I do not know whether I will ever meet you again at "
//            + "this place after this year. Behold! all practices of paganism and ignorance are now under my "
//            + "feet. The blood-revenge of the Days of Ignorance are remitted. Usury is forbidden."
//            + "It is unlawful for you to shed the blood of one another or unlawfully take the fortunes of one "
//            + "another. They are as unlawful as shedding blood on such a day as today and in such a month "
//            + "as this sacred month and in such a sanctified city as this sacred city. "
//            + "The weak amongst you, feed them on what you eat, dress them as you are dressed. You will "
//            + "meet your God and He will call you to account for your actions."
//            + "Let those who are present warn those who are absent. You are all descended from Adam "
//            + "and the best of you are those who best regard God. "
//            + "Think deeply about what I say, let all your feuds be abolished, you must know that every "
//            + "Muslim is brother of every other Muslim, and all Muslims are brothers, one to another. "
//            + "Between Muslims there are no races and no tribes. "
//            + "You must not take anything from your brother except what is given freely. Don’t oppress "
//            + "and don’t be oppressed. "
//            + "Oh my people, I am but a man it may be that the Angel of Death will visit me soon, and "
//            + "death will overtake me. But I have left you a book, revealed by God, the Quran, which is "
//            + "light and guidance. "
//            + "This day, I have perfected your religion to you and completed my favor to you. And have "
//            + "chosen for you Islam as your religion.";
//
////        Twitter tw = connect();
////        StringDivider sd = new StringDivider (islamText, 120);
////        String[] ls = sd.divideWords();
////        sendStringArray (ls, tw);
//      
//        /*
//سبحان الله               ،    الحمدلله ، الله أكبر   . 
//            Subhan Allah , AlHamdulillah , Allahu Akbar .
//        */
//        MDIApplication.main (null);
//        
////        int surnum = 107;
////        Quran q = new ZippedQuran (1);
////        String sura = q.getSura (surnum);
////        DebugOut.get().out.println (sura);
////        VerbalQuran vq = new VerbalQuran();
////        vq.play(surnum);
////        vq.play(1,2);
////        vq.play(1,3);
////        vq.play(1,4);
////        vq.play(1,5);
////        vq.play(1,6);
////        vq.play(1,7);
////        vq.play(1,8);
//        
////        Twitter tw = connect();
////        StringDivider sd = new StringDivider (sura, 120);
////        String[] ls = sd.divideWords();
////        sendStringArray (ls, tw);
//    }
}
