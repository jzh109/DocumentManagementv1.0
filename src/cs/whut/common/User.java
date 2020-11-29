package cs.whut.common;

public abstract class User {
	private String name;
	private String password;
	private String role;
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeSelfInfo(String password){
		if (DataProcessing.update(name, password, role)){
			this.password=password;
			System.out.println("Information change succeed!");
			return true;
		}else
			return false;
	}
	
	public abstract void showMenu();

	public boolean downloadFile(String filename){
		System.out.println("Download file......");
		return true;
	}

	public boolean uploadFile(String filename, String fileNumber, String fileDescription){
		System.out.println("Uploading file.......");
		return true;
	}
	
	public void showFileList(){
		System.out.println("List......");
	}
	
	public void exitSystem(){
		System.out.println("System has exit,thanks for utilizing!");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}


}
