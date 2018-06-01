#include<stdio.h>
#include<sys/ipc.h>
void main(){
	int msgid;
	struct{
		long mtype;
		char fname[200];
		
		}msgbuf;
		msgid=msgget((key_t)10,IPC_CREAT|0666);
		msgrcv(msgid,&msgbuf,sizeof(msgbuf),0,0);
		printf("\n msg Recived %s",msgbuf.fname);
		
		
	}
