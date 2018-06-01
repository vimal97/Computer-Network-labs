#include<stdio.h>
void main(){
	int pipefd[2],n,pid;
	char buff[100];
	pipe(pipefd);
	pid=fork();
	if(pid==0){
		close(pipefd[0]);                                               //closing read end of the pipe
		printf("\n Child is writting\n");
		write(pipefd[1],"sample",6);
		
		}
		else{
			printf("\n Parent is reading data from pipe\n");
			close(pipefd[1]);                                           //closing write end of the pipe
			n=read(pipefd[0],buff,sizeof(buff));
			printf("\n Data recived through pipe have size %d value '%s'\n",n,buff);
			
			}
}
