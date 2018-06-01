#include<stdio.h>
#include<sys/ipc.h>

void main(){
	int msgid;
	struct{
		long mtype;
		char fname[200];
		}msgbuf;
	msgid=msgget((key_t)10,IPC_CREAT|0666);
	printf("\nEnter data");
	scanf("%s",msgbuf.fname);
	msgsnd(msgid,&msgbuf,sizeof(msgbuf),0);
	
}
