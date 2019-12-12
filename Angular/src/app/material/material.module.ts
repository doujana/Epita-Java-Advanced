import { NgModule } from '@angular/core';
import {MatButtonModule, MatToolbarModule, MatCardModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatTableModule, MatRadioButton, MatRadioModule, MatTableDataSource} from '@angular/material'

const materialcomponent=[MatButtonModule,MatToolbarModule,MatCardModule,MatButtonModule,MatFormFieldModule,MatInputModule,MatSelectModule,
MatTableModule,MatSelectModule,MatRadioModule,MatTableModule]

@NgModule({
  
  imports: [materialcomponent],
  exports:[materialcomponent]
})
export class MaterialModule { }
