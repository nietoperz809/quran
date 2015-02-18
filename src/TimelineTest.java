
import java.util.List;
import twitter.TwitTools;
import twitter4j.Status;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class TimelineTest
{
    public static void main(String[] args)
    {
        List<Status> l = TwitTools.getTimeLine();
        for (Status status : l)
        {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }
}