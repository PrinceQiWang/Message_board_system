package cpc.message;
public class ListNoteBean {
	private int id;
	private String title;
	private String author;
	private String content;
	private String reply;
	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public String getContent(){
		return content;
	}
	public String getReply(){
		return reply;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public void setContent(String content){
		this.content=content;
	}
	public void setReply(String reply){
		this.reply=reply;
	}
}