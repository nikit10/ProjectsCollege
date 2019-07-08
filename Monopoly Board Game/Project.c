#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<malloc.h>
int num_of_play,status[40],price[40],buy[20];
char *pos[40],enter;
int f=20000,g=20000,h=20000,j=20000;
int x,i,ch,z,y;
int dice,q=1,w=1,e=1,r=1;
int end();
struct node
{
int num;
char *state[20];
struct node *prev,*next;
};
struct node *start;
//Creating a Empty List
void CreateEmptyList()
{
 start =NULL;
}
//Inserting a state in a doubly link-list
void insert(int item,char *name,int pos)
{
struct node *p;
p=(struct node * ) malloc (sizeof(struct node));
p->num=item;
p->state[pos]=name;
p->prev=p->next=NULL;

	if(start!=NULL)
	{   p->next=start;
		start->prev=p;
		start=p;
	}
	else
	{
		start =p;
	}*
	//printf(" %d \n %s",p->num,p->state[pos]);
}
//To check in which players account is the state..
void checkState(struct node *start,char *position,int var)
{
struct node *temp;
temp=start;
     while(temp!=NULL)
      {
      	//printf(" %d \n %s \n %s",temp->num,temp->state[var],position);
      	if(temp->state[var]!=NULL){
      	int rc = strcmp(temp->state[var],position);
		if(rc==0){
			y=temp->num;
			if(y==i){
				printf("Welcome this is your own property. Hope you enjoy being here!! :-)");
			}
			else if(y==1){
				f=f+price[var];
				printf("\nThe place is owned by {P1} rent(%d) is added to {P1}'s account.",price[var]);	
			}
			else if(y==2){
				g=g+price[var];
				printf("\nThe place is owned by {P2} rent(%d) is added to {P2}'s account.",price[var]);
			}
			else if(y==3){
				h=h+price[var];
				printf("\nThe place is owned by {P3} rent(%d) is added to {P3}'s account.",price[var]);
			}
			else{
				j=j+price[var];
				printf("\nThe place is owned by {P4} rent(%d) is added to {P4}'s account.",price[var]);
			}
			temp=NULL;
		}
		}
		else{
		temp=temp->next;
		}
      }
}
int result(){
	q=0;
	w=0;
	e=0;
	r=0;
	if(num_of_play==2){
		h=-2000;
		j=-2000;
	}
	if(num_of_play==3){
		j=-2000;
	}
	struct node *check;
	check=start;
	while(check!=NULL){
		y=check->num;
		if(y==1){
			q++;
		}
		if(y==2){
			w++;
		}
		if(y==3){
			e++;
		}
		if(y==4){
			r++;
		}
		check=check->next;
	}
		q=q*2500;
		f=f+q;
		w=w*2500;
		g=g+w;
		e=e*2500;
		h=e+h;
		r=r*2500;
		j=j+r;
		if(f>=g&&f>=h&&f>=j){
			printf("\n{P1} is the winner");
		}
		else if(g>=h&&g>=j){
			printf("\n{P2} is the winner");
		}
		else  if(h>=j){
			printf("\n{P3} is the winner");
		}
		else{
			printf("\n{P4} is the winner");
		}
		printf("\n****Congratulations on winning the Ultimate game of Bussiness****");
		return 0;
}
int community(int y,int k){
	if(y==1){
		printf("\nGo to jail and pay Rs.500");
		z=-500;
		k=6;
	}
	else if(y==2){
		z=500*(num_of_play-1);
		printf("\nHappy birthday each player gave you Rs.500 as a gift you recieved %d",z);
		f=f-500;
		g=g-500;
		h=h-500;
		j=j-500;
		z=500*num_of_play;
	}
	else if(y==3){
		printf("\nFees costs a total of Rs.1000");
		z=-1000;
	}
	else if(y==4){
		printf("\nCongrats for your win at the race collect Rs.2500/- as the cash prize");
		z=2500;
	}
	else if(y==5){
		printf("\nAll players recieved a party from you which costs a total of Rs.2000/-");
		z=2000;
	}
	else{
		k=16;
		printf("\nNow you are at rest house");
		z=500;
	}
	return z;
	return k;
}
int chance(int y){
	if(y==1){
		printf("\nConrgratuations on winning lottery of Rs.2500");
		z=2500;
	}
	else if(y==2){
		printf("\nSorry for your loss in share market of Rs.2000");
		z=-2000;
	}
	else if(y==3){
		printf("\nCongrats for Best performance in export.You have won Rs.3000");
		z=3000;
	}
	else if(y==4){
		printf("\nSorry for your accident loss of Rs.1000");
		z=-1000;
	}
	else if(y==5){
		printf("\nCongrats for winning Rs.1000 in crossword puzzle");
		z=1000;
	}
	else{
		printf("\nYour house has repaired.The repair costs a total of Rs.3000");
		z=-3000;
	}
}
int check(){
	status[1]=5;
	status[2]=1;
	status[3]=1;
	status[4]=3;
	status[5]=1;
	status[6]=4;
	status[7]=1;
	status[8]=1;
	status[9]=3;
	status[10]=1;
	status[11]=4;
	status[12]=1;
	status[13]=1;
	status[14]=3;
	status[15]=1;
	status[16]=6;
	status[17]=1;
	status[18]=1;
	status[19]=3;
	status[20]=1;
}
int data(){
	pos[1]="Start(After crossing it collect 2500/- from the bank)";
	pos[2]="Mumbai";
	pos[3]="Railway";
	pos[4]="Chance(Check the middle of the board)";
	pos[5]="Jaipur";
	pos[6]="Jail";
	pos[7]="Delhi";
	pos[8]="Best";
	pos[9]="Community Chest(Check the middle of the board)";
	pos[10]="Srinagar";
	pos[11]="Club(Pay 500 to bank)";
	pos[12]="Chennai";
	pos[13]="Air India";
	pos[14]="Chance(Check the middle of the board)";
	pos[15]="Hyderabad";
	pos[16]="Rest House(Recieve 500 from bank)";
	pos[17]="Agra";
	pos[18]="Motor Boat";
	pos[19]="Community Chest(Check the middle of the board)";
	pos[20]="Ooty";	
}
int rent(){
	price[2]=1500;
	price[3]=950;
	price[5]=350;
	price[7]=1000;
	price[8]=350;
	price[10]=500;
	price[12]=400;
	price[13]=1500;
	price[15]=600;
	price[17]=350;
	price[18]=550;
	price[20]=250;
}
int cost(){
	buy[2]=8500;
	buy[3]=9500;
	buy[5]=3000;
	buy[7]=6000;
	buy[8]=3500;
	buy[10]=5000;
	buy[12]=2500;
	buy[13]=10500;
	buy[15]=3500;
	buy[17]=3500;
	buy[18]=5500;
	buy[20]=2500;
}
int board(){
	printf("_______________________________________________________________________________________________________\n");
	printf("|                |                |                |   COMMUNITY    |                |                |\n");
	printf("|      JAIL      |     DELHI      |      BEST      |     CHEST      |    SRINAGAR    |      CLUB      |\n");
	printf("|________________|________________|________________|________________|________________|________________|\n");
	printf("|  |  |  |  |  | |  Cost:-        |  Cost:-        | See the middle |  Cost:-        |                |\n");
	printf("|  |  |  |  |  | |   Buy:6000     |   Buy:3500     |     of the     |   Buy:5000     |                |\n");
	printf("|  |  |  |  |  | | House:1500     |                | 	 Board.     | House:1000     |    Rent:500    |\n");
	printf("|  |  |  |  |  | |  Rent:1000     |  Rent:350      |                |  Rent:500      |                |\n");
	printf("|__|__|__|__|__|_|________________|________________|________________|________________|________________|\n");
	printf("|                |                                                                   |                |\n");
	printf("|     JAIPUR     |                                                                   |    CHENNAI     |\n");
	printf("|________________|                                                                   |________________|\n");
	printf("|  Cost:-        |       __________________            __________________            |   Cost:-       |\n");
	printf("|   Buy:3000     |       |                |            |   COMMUNITY    |            |    Buy:2500    |\n");
	printf("| House:800      |       |     CHANCE     |            |     CHEST      |            |  House:900     |\n");
	printf("|  Rent:350      |       |________________|            |________________|            |   Rent:400     |\n");
	printf("|________________|       |1.lottery prize |            |1.Go to jail &  |            |________________|\n");
	printf("|                |       |   Rs.2500/-    |            |pay Rs.500/-    |            |                |\n");
	printf("|     CHANCE     |       |2.Loss in share |            |2.It is your    |            |   AIR INDIA    |\n");
	printf("|________________|       |market Rs.2000/-|            |birhtday collect|            |________________|\n");
	printf("| See the middle |       |3.Prize for best|            |Rs.500/- from   |            |   Cost:-       |\n");
	printf("|     of the     |       |performance in  |            |each player.    |            |    Buy:10500   |\n");
	printf("|     Board.     |       |Export,Rs.3000. |            |3.School and    |            |                |\n");
	printf("|                |       |4.Accident loss |            |medical fees    |            |   Rent:1500    |\n");
	printf("|________________|       |Rs.1000/- lost. |            |Rs.1000/-       |            |________________|\n");
	printf("|                |       |5.You won cross-|            |4.1st prize in  |            |                |\n");
	printf("|    RAILWAY     |       |word prize 1000.|            |racing collect  |            |     CHANCE     |\n");
	printf("|________________|       |6.House repair  |            |Rs.2500/-       |            |________________|\n");
	printf("|   Cost:-       |       |Rs.3000/-.      |            |5.Party costs   |            | See the middle |\n");
	printf("|    Buy:9500    |       |                |            |Rs.2000/-       |            |     of the     |\n");
	printf("|                |       |                |            |6.Go to rest    |            |     Board.     |\n");
	printf("|   Rent:950     |       |                |            |house and play  |            |                |\n");
	printf("|________________|       |                |            |on next turn.   |            |________________|\n");
	printf("|                |       |________________|            |________________|            |                |\n");
	printf("|     MUMBAI     |                                                                   |    HYDERABAD   |\n");
	printf("|________________|                                                                   |________________|\n");
	printf("|   Cost:-       |                                                                   |   Cost:-       |\n");
	printf("|    Buy:8500    |                                                                   |    Buy:3500    |\n");
	printf("|  House:2500    |                                                                   |  House:1200    |\n");
	printf("|   Rent:1500    |                                                                   |   Rent:600     |\n");
	printf("|________________|___________________________________________________________________|________________|\n");
	printf("|                |                |   COMMUNITY    |     MOTOR      |                |                |\n");
	printf("|     START      |      OOTY      |     CHEST      |      BOAT      |     AGRA       |   REST HOUSE   |\n");
	printf("|________________|________________|________________|________________|________________|________________|\n");
	printf("|Collect Rs.2500 |   Cost:-       | See the middle |   Cost:-       |   Cost:-       |CONGRATULATIONS:|\n");
	printf("| each time you  |    Buy:2500    |     of the     |    Buy:5500    |    Buy:3500    |  YOU HAVE WON  |\n");
	printf("|  you cross     |  House:1000    |     board.     |                |  House:1000    |    Rs.500      |\n");
	printf("|     start      |   Rent:250     |                |   Rent:550     |   Rent:350     |                |\n");
	printf("|________________|________________|________________|________________|________________|________________|\n");	
}
int cont(){
printf("\nPress 1 to continue\n      2 to exit:");
	scanf("%d",&x);
	if(x==1){
	board();}
	else if(x==2){
		return 0;
	}
	else{
		printf("\nEnter a valid option.");
		cont();
	}
}
int move(){
	for(i=1;i<=num_of_play;i++){
	dice = rand()%6 + 1;
	printf("\nCHANCE OF PLAYER %d :-\n\n",i);
	printf("The roll comes out to be %d \n",dice);
	if(i==1){
		q=q+dice;
		if(q>20){
			q=q-20;
			if(q!=1){
			f=f+2500;
			printf("\nCongratulations you have now crossed start and have earned Rs.2500 \nNow your account balance is %d",f);
			}
			else{
				f=f+2500;
			}
		}
	printf("\nYou have landed on %s",pos[q]);
		if(status[q]==0){
			f=f-price[q];
			printf("\nThe rent of the place has been deducted from your account:\nNow your account balance is %d",f);
			checkState(start,pos[q],q);
			scanf("%c",&enter);
		}
		else if(status[q]==1){
			printf("\nYour account balance is Rs.%d.",f);
			printf("\nPlease select what you want to do:\n1.Buy\n2.Move on\n");
			scanf("%d",&x);
			if(x==1){
				if(f>=buy[q]){
					f=f-buy[q];
					printf("\nThe amount has been detucted from your account the balance of your account is %d",f);
					printf("\n\n***********************Congratulations{P1} you now own %s**********************\n",pos[q]);
					insert(1,pos[q],q);
					status[q]=0;
				}
				else{
					printf("\nYou have insufficient balance.\n");
				}
			}
		}
		else if(status[q]==3){
			printf("\nCheck the middle of the board \n");
			board();
			if(q==4||q==14){
				chance(dice);
			}
			else{
				community(dice,q);
			}
			f=f+z;
			printf("\nNow your balance is Rs.%d",f);
			scanf("%s",&enter);
		}
		else if(status[q]==4){
			f=f-500;
			printf("\nYou have to pay Rs.500/-.\n The amount has been deducted from your account now your balance is %d\n",f);
			scanf("%s",&enter);
		}
		else if(status[q]==5){
			printf("\nYou will recieve Rs.2500/- Once you have crossed it.");
			printf("\nThat means your balance will be Rs.%d",f);
			scanf("%s",&enter);
		}
		else{
			f=f+500;
			printf("\nCongrats you have won Rs.500/-");
			scanf("%s",&enter);
		}
	}
		
	//chanceof second player
	else if(i==2){
		w=w+dice;
		if(w>20){
			w=w-20;
			if(w!=1){
			g=g+2500;
			printf("Congratulations you have now crossed start and have earned Rs.2500 \nNow your account balance is %d",g);
			}
			else{
				g=g+2500;
			}				
		}
		printf("You have landed on %s \n",pos[w]);
		if(status[w]==0){
			g=g-price[w];
			printf("\nThe rent of the place has been deducted from your account:\n now your account balance is %d\n\n",g);
			checkState(start,pos[w],w);
			scanf("%s",&enter);
		}
		else if(status[w]==1){
			printf("\nYour account balance is Rs.%d.",g);
			printf("Please select what you want to do:\n1.Buy\n2.Move on\n");
			scanf("%d",&x);
			if(x==1){
				if(g>=buy[w]){
					g=g-buy[w];
					printf("\nThe amount has been detucted from your account the balance of your account is %d",g);
					insert(2,pos[w],w);
					printf("\n\n***********************Congratulations{P2} you now own %s**********************\n\n",pos[w]);
					status[w]=0;
				}
				else{
					printf("You have insufficient balance.");
				}
			}
		}
		else if(status[w]==3){
			printf("Check the middle of the board \n \n");
			board();
			if(w==4||w==14){
				chance(dice);
			}
			else{
				community(dice,w);
			}
			g=g+z;
			printf("\nNow your balance is Rs.%d",g);
			scanf("%s",&enter);
		}
		else if(status[w]==4){
			g=g-500;
			printf("You have to pay Rs.500/-.\n The amount has been deducted from your account now your balance is %d",g);
			scanf("%s",&enter);
		}
		else if(status[w]==5){
			printf("You will recieve Rs.2500/- Once you have crossed it.");
			printf("\nThat means your balance will be Rs.%d",g);
			scanf("%s",&enter);
		}
		else{
			g=g+500;
			printf("Congrats you have won Rs.500/-");
			scanf("%s",&enter);
		}
		}	
	//Chance of 3rd player
	else if(i==3){
		e=e+dice;
		if(e>20){
			e=e-20;
			if(e!=1){
			h=h+2500;
			printf("Congratulations you have now crossed start and have earned Rs.2500 \nNow your account balance is %d",h);
			}
			else{
				h=h+2500;
			}				
		}
		printf("You have landed on %s \n",pos[e]);
		if(status[e]==0){
			h=h-price[e];
			printf("\nThe rent of the place has been deducted from your account:\n now your account balance is %d",h);
			checkState(start,pos[e],e);
			scanf("%s",&enter);
		}
		else if(status[e]==1){
			printf("\nYour account balance is Rs.%d.",h);
			printf("Please select what you want to do:\n1.Buy\n2.Move on\n");
			scanf("%d",&x);
			if(x==1){
				if(h>=buy[e]){
					h=h-buy[e];
					printf("\nThe amount has been detucted from your account the balance of your account is %d",h);
					insert(3,pos[e],e);
					printf("\n\n***********************Congratulations{P3} you now own %s**********************\n\n",pos[e]);
					status[e]=0;
				}
				else{
					printf("You have insufficient balance.");
				}
			}
		}
		else if(status[e]==3){
			printf("Check the middle of the board \n \n");
			board();
			if(e==4||e==14){
				chance(dice);
			}
			else{
				community(dice,q);
			}
			h=h+z;
			printf("\nNow your balance is Rs.%d",h);
		}
		else if(status[e]==4){
			h=h-500;
			printf("You have to pay Rs.500/-.\n The amount has been deducted from your account now your balance is %d",h);
			scanf("%s",&enter);
		}
		else if(status[e]==5){
			printf("You will recieve Rs.2500/- Once you have crossed it.");
			printf("\nThat means your balance will be Rs.%d",h);
			scanf("%s",&enter);
		}
		else{
			h=h+500;
			printf("Congrats you have won Rs.500/-");
			scanf("%s",&enter);
		}
		}
		//chance of player 4
	else if(i==4){
		r=r+dice;
		if(r>20){
			r=r-20;	
			if(r!=1){
			j=j+2500;
			printf("Congratulations you have now crossed start and have earned Rs.2500 \nNow your account balance is %d",j);
			}
			else{
				j=j+2500;
			}			
		}
		printf("You have landed on %s \n",pos[r]);
		if(status[r]==0){
			j=j-price[r];
			printf("\nThe rent of the place has been deducted from your account:\n now your account balance is %d",j);
			checkState(start,pos[r],r);
			scanf("%s",&enter);
		}
		else if(status[r]==1){
			printf("\nYour account balance is Rs.%d.",j);
			printf("Please select what you want to do:\n1.Buy\n2.Move on\n");
			scanf("%d",&x);
			if(x==1){
				if(j>=buy[r]){
					j=j-buy[r];
					printf("\nThe amount has been detucted from your account the balance of your account is %d",j);
					insert(4,pos[r],r);
					printf("\n\n***********************Congratulations{P4} you now own %s**********************\n\n",pos[r]);
					status[r]=0;
				}
				else{
					printf("You have insufficient balance.");
				}
			}
		}
		else if(status[r]==3){
			printf("Check the middle of the board \n \n");
			board();
			if(r==4||r==14){
				chance(dice);
			}
			else{
				community(dice,r);
			}
			j=j+z;
			printf("Now your balance is Rs.%d",j);
			scanf("%s",&enter);
		}
		else if(status[r]==4){
			j=j-500;
			printf("You have to pay Rs.500/-.\n The amount has been deducted from your account now your balance is %d",j);
			scanf("%s",&enter);
		}
		else if(status[r]==5){
			printf("You will recieve Rs.2500/- Once you have crossed it.");
			printf("\nThat means your balance will be Rs.%d",j);
			scanf("%s",&enter);
		}
		else{
			j=j+500;
			printf("Congrats you have won Rs.500/-");
			scanf("%s",&enter);
		}
		}	
	}
	if(f<0){
		printf("\n{P1} has been bankrupt the game is stopped and the result is:-");
		result();
	}
	if(g<0){
		printf("\n{P2} has been bankrupt the game is stopped and the result is:-");
		result();
	}
	if(h<0){
		printf("\n{P3} has been bankrupt the game is stopped and the result is:-");
		result();
	}
	if(j<0){
		printf("\n{P4} has been bankrupt the game is stopped and the result is:-");
		result();
	}
	//asking to exit the program and get the winner
	end();
}
int rules(){
	printf("*************************************************RULES & REGULATIONS*************************************************");
	printf("\n1.Each player is provided with 20000 rupees which he could further use to buy, pay rent to the owner of the state.");
	printf("\n2.Every time the player crosses start he recieves 2500 rupees as bonus from the bank.");
	printf("\n3.When a player lands on a state the player can either buy or move on, only if the state does not belong to another\n player.");
	printf("\n4.The player who has to pay a rent pays it to the owner of the property not the bank.");
	printf("\n5.If a player lands on jail he has to pay 500 to bank .");
	printf("\n6.If the player lands on club he has to pay 500 to the bank.");
	printf("\n7.If the player lands on rest house he recieves 500 from the bank.");
	printf("\n8.If the player lands on community chest or chance the player have to see the middle of the board and has to do according\n");
	printf("as asked along his dice number as directed.");
	printf("\n9.If a player is bankrupt the game stops the and there and the winner is announced.");
	printf("\n10.If all the players accept to quit the game the total money and properties owned by the players are calculated and \n");
	printf("And the winner is anounced.\n");
	cont();
}
int num(){
	printf("\nEnter the number of players who want to play:");
	scanf("%d",&num_of_play);
	if(num_of_play<2 || num_of_play>4){
		printf("The number of players must be between 2 and 4. :)\n");
		num();
	}
}
//asking to exit the program and get the winner
int end(){
	printf("Do you want to continue or end the game now and get the winner:-\n1.Press 1 to cont.\n2.Press to get the result.");
	scanf("%d",&x);
	if(x==1){
	move();
	}
	else if(x==2){
		result();
	}
	else{
		printf("Incorrect input.Please enter a valid input");
		end();
	}
}
int main(){
	data();
	rent();
	cost();
	CreateEmptyList();
	check();
	printf("*******************************************WELCOME TO THE BUSINESS GAME BOARD****************************************\n");
	num();
	rules();
	move();
	return 0;
}
