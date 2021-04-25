/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class Controller {
    private View view; 
    private WhoWantsToBeAMillionaire model;
    
    public Controller(View view, WhoWantsToBeAMillionaire model){
        
        this.view = view;
        this.model = model;
       
        
        model.q = model.randomQuestion();
        updateQuestionGui();
        view.questionPanel.addQButtonListener(new AnswerListener1());
        view.menuCard.addMButtonListener(new AnswerListener2());
        view.addReturnButtonListener(new AnswerListener3());
        view.namePanel.addNameTextListener(new AnswerListener5());
    }
    void updateQuestionGui(){
       
        String[] answers = new String[]{model.q.correct, model.q.wrong1, model.q.wrong2, model.q.wrong3};
        ArrayList<String> shuffledAnswers = new ArrayList<>(Arrays.asList(answers));
        Collections.shuffle(shuffledAnswers);
        view.questionPanel.questionArea.setText(model.q.question);
        view.questionPanel.a.setText("A. "+shuffledAnswers.get(0));
        view.questionPanel.b.setText("B. "+shuffledAnswers.get(1));
        view.questionPanel.c.setText("C. "+shuffledAnswers.get(2));
        view.questionPanel.d.setText("D. "+shuffledAnswers.get(3));
        view.questionPanel.qNum.setText("Question "+model.lvl.toString()+".");
        view.questionPanel.winnings.setText("$"+model.a.money.toString());
    }
    
    
    class AnswerListener1 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(view.questionPanel.a)){
                
                if(view.questionPanel.a.getText().contains(model.q.correct)){
               // view.an.setText(model.lvl.toString());
                     model.addWinnings();
                    
                    if(model.a.money != 1000000){
                        model.lvl++;
                        model.UpdateQuestion();
                        updateQuestionGui();
                    }
               //view.updateQuestionGui();
               // view.validate();
                //view.repaint();
                
                }
                else{
                    //view.winnings.setText("LOSER");
                    view.gameOverPanel.winnings.append(model.a.money.toString());
                    view.cl.show(view.panelCont, "3");
                    model.lvl = 1;
                    try {
                            model.fc.addContestantToFile(model.a);
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    updateQuestionGui();
                }
            }
            else if(e.getSource().equals(view.questionPanel.b)){
               
                if(view.questionPanel.b.getText().contains(model.q.correct)){
                   // view.an.setText(model.lvl.toString());
                    model.addWinnings();
                   
                    if(model.a.money != 1000000){
                    model.lvl++;
                    model.UpdateQuestion();
                       
                    updateQuestionGui();
                    }
                }
                 else{
                      //view.winnings.setText("LOSER");
                      view.gameOverPanel.winnings.append(model.a.money.toString());
                      view.cl.show(view.panelCont, "3"); 
                      
                      model.lvl = 1;
                       try {
                            model.fc.addContestantToFile(model.a);
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       updateQuestionGui();
                 }
            }    
            else if(e.getSource().equals(view.questionPanel.c)){
                
                if(view.questionPanel.c.getText().contains(model.q.correct)){
                   // view.an.setText(model.lvl.toString());
                    model.addWinnings();
                    
                    if(model.a.money != 1000000){
                        
                        model.lvl++;
                        model.UpdateQuestion();
                        
                        updateQuestionGui();
                    }
                }
                 else{
                      //view.winnings.setText("LOSER");
                      view.gameOverPanel.winnings.append(model.a.money.toString());
                      view.cl.show(view.panelCont, "3");
                       model.lvl = 1;
                       try {
                            model.fc.addContestantToFile(model.a);
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       updateQuestionGui();
                }
            }
            else if(e.getSource().equals(view.questionPanel.d)){
               
                if(view.questionPanel.d.getText().contains(model.q.correct)){
                
                   // view.an.setText(model.lvl.toString());
                    model.addWinnings();
                    if(model.a.money != 1000000){
                        model.lvl++;
                        model.UpdateQuestion();
                        updateQuestionGui();
                    }
                }
                else{
                    //view.winnings.setText("LOSER");
                   
                    try {
                            model.fc.addContestantToFile(model.a);
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    view.gameOverPanel.winnings.append(model.a.money.toString());
                    view.cl.show(view.panelCont, "3"); 
                    model.lvl = 1;
                }
            }
            
            
            if(model.a.money == 1000000){
               // view.winnings.setText("WINNER");
                view.cl.show(view.panelCont, "7"); 
                model.lvl = 1;
                try {
                            model.fc.addContestantToFile(model.a);
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                model.UpdateQuestion();
                updateQuestionGui();
            }
            
            
        }
}
    class AnswerListener2 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(view.menuCard.play)){
                
               view.cl.show(view.panelCont, "6"); 
            }
            else if(e.getSource().equals(view.menuCard.gList)){
                
                clearGamesTable();
                buildGamesTable();    
                view.cl.show(view.panelCont, "4"); 
               
            }
            else if(e.getSource().equals(view.menuCard.wList)){
                clearWinTable();
                buildWinTable(); 
               view.cl.show(view.panelCont, "5"); 
            }
        }
        
        }
    class AnswerListener3 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.panelCont, "1"); 
            view.gameOverPanel.winnings.setText("You finished with: $");
        }
        
        }
     class AnswerListener4 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.panelCont, "4"); 
        }
        
        }
    
     
     public void clearGamesTable(){
         view.gameHistoryPanel.gameTableModel.setRowCount(0);
     }
     
     public void buildGamesTable(){
        List<Contestant> contestants = new ArrayList<>();
        contestants = model.fc.FetchContestantList();
        Collections.reverse(contestants);
// String data[][] = new String[contestants.size()][3];
       // String[] header = { "Name", "Winnings", "Date" };
        for (Contestant contestant : contestants) {
            view.gameHistoryPanel.gameTableModel.addRow(new Object[]{contestant.name, contestant.money, contestant.date});
        }
        //System.out.println(data[0][0]+" "+data[0][1]+" "+data[0][2]);
        //view.table = new JTable(data, header);
     }
      
      public void clearWinTable(){
         view.winnerListPanel.winTableModel.setRowCount(0);
     }
     
     public void buildWinTable(){
        List<Contestant> contestants = new ArrayList<>();
        contestants = model.fc.FetchContestantList();
      
        for (Contestant contestant : contestants) {
        
            if(contestant.money == 1000000){
            view.winnerListPanel.winTableModel.addRow(new Object[]{contestant.name, contestant.date});
        }
        }
     }
     
     class AnswerListener5 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            Contestant g = new Contestant(view.namePanel.name.getText());
            model.a = g;
            view.cl.show(view.panelCont, "2"); 
            view.namePanel.name.setText(" ");
            updateQuestionGui();
            view.questionPanel.nameLabel.setText("Contestant: "+model.a.name);
        }
        
        }
}
        
    