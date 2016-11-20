package example.com.redditlike.parsingclasses;


import java.util.List;

public class ReturnDataReddit
{
    Data data;

    public class Data
    {

       List<Children>  children;

       public class Children
        {

            DataInside data;

           public class DataInside
            {
                String title;
                String author;
                String url;
                String thumbnail;
                String num_comments;
                String ups;

                public String getAuthor()
                {
                    return author;
                }

                public String getTitle() {
                    return title;
                }

                public String getUrl()
                {
                    return url;
                }


                public String getThumbnail()
                {
                    return thumbnail;
                }


                public String getNum_comments()
                {
                    return num_comments;
                }

                public String getUps() {
                    return ups;
                }
            }

            public DataInside getData() {
                return data;
            }
        }

        public List<Children> getChildren() {
            return children;
        }
    }

    public Data getData() {
        return data;
    }
}
