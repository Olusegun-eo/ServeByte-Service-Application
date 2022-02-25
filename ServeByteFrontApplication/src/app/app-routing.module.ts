import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { MenuComponent } from './menu/menu.component';
import { ContactFormComponent } from './contact-form/contact-form.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'home' },
    { path: 'home', component: HomeComponent },
    { path: 'about', component: AboutPageComponent },
    { path: 'menu', component: MenuComponent },
    { path: 'contact', component: ContactFormComponent },
    { path: 'gohome', redirectTo: 'home' }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }