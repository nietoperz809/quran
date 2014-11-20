package twittools;

import java.io.IOException;
import twitter4j.Status;
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
    static private Twitter m_twit = null;
    
    private TwitTools()
    {
        try
        {
            m_twit = connect();
        }
        catch (Exception ex)
        {
            m_twit = null;
        }
    }
    
    public static TwitTools get()
    {
        if (m_instance == null)
            m_instance = new TwitTools();
        return m_instance;
    }
    
    public static Twitter connect() throws TwitterException, IOException
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consuerSecret)
                .setOAuthAccessToken(accessKey)
                .setOAuthAccessTokenSecret(accessSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;
    }

    public void sendStringArray(String[] sa) throws Exception
    {
        if (m_twit == null)
            return;
        
        for (String s : sa)
        {
            Status st = m_twit.updateStatus(s);
            System.out.println(st.getText());
            //Thread.sleep (36000);
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
////        System.out.println (sura);
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
