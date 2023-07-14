import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from './service.service';
import { LinkArtcile } from './LinkArticle';
import { Product } from './Product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'form';
  addProduct: FormGroup;
  websites: any[];
  products: any[];

  site: any | undefined;

  constructor(private fb: FormBuilder, private service: ServiceService) {}

  ngOnInit(): void {
    let tab: []
    var tableauJSON = JSON.stringify(tab);
    localStorage.setItem("obj", tableauJSON)
    this.websites = [
      { name: 'amazon' },
      { name: 'shein' },
      { name: 'eastpark', code: 'LDN' },
    ];

    this.buildForm();
    this.getproduct()
  }

  buildForm() {
    this.addProduct = this.fb.group({
      link: ['', Validators.required],
      siteName: ['', Validators.required],
    });
  }

  handleOk() {
    console.log(this.addProduct.value);
    let obj: LinkArtcile={
      path: this.addProduct.value.link,
      origin: this.addProduct.value.siteName.name
    }
    console.log(obj)
    this.service.getArticles(obj).subscribe({
      next: value =>{
        console.log(value)
        let tab: []
        localStorage.setItem("obj", JSON.stringify(value))
        this.getproduct()
      }
    });
  }
  getproduct(){
    let p: any
    p = localStorage.getItem("obj")

    p = JSON.parse(p)
    console.log(p)
    this.products= [p]
  }
}
